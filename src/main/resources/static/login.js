document.getElementById("loginForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const userId = document.getElementById("userId").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8080/api/users/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ userId, password }),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Login failed");
            }
            return response.json();
        })
        .then(async user => {
            // Save user info
            localStorage.setItem("loggedInUser", JSON.stringify(user));

            if (user.role === "Admin") {
                window.location.href = "admin.html";
            } else {
                // Get latest leave request
                const response = await fetch(`http://localhost:8080/api/leaves/latest-status/${user.userId}`);
                if (response.ok) {
                    const latestLeave = await response.json();

                    if (latestLeave && latestLeave.status && latestLeave.status !== "PENDING") {
                        const name = user.name || user.userId;
                        const fromDate = latestLeave.startDate;
                        const toDate = latestLeave.endDate;
                        const status = latestLeave.status;

                        if (status === "APPROVED") {
                            alert(
                                `Dear ${name},\n` +
                                `Your leave request from ${fromDate} to ${toDate} has been graciously approved.\n` +
                                `Enjoy your time off. 😊`
                            );
                        } else if (status === "REJECTED") {
                            alert(
                                `Dear ${name},\n` +
                                `Sadly, your leave request from ${fromDate} to ${toDate} has been rejected.\n` +
                                `Please contact your admin for further clarification.`
                            );
                        }
                    }
                }

                // Redirect after alert
                window.location.href = "dashboard.html";
            }
        })
        .catch(error => {
            alert("Invalid credentials or server error.");
            console.error("Error:", error);
        });
});
