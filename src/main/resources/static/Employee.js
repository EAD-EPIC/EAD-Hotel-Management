 fetch("http://localhost:8080/employee")

    .then(response => response.json())
    .then(json => {

    let li = `<tr>
        <th>Employee Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>`;

    json.forEach(employee => {
    li += `<tr>
                <td>${employee.employeeId} </td>
                <td>${employee.firstName} </td>
                <td>${employee.lastName}</td>
                <td>${employee.email}</td>
                <td>${employee.gender}</td>
                <td>${employee.address}</td>
                <td>${employee.phone}</td>
                 <td>
                         <button class="edit_btn" onclick="editEmployee(${employee.employeeId})">Edit</button>
                        <button class="delete_btn" onclick="deleteEmployee(${employee.employeeId})">Delete</button>
        </td>
            </tr>`;
});
    document.getElementById("employees").innerHTML = li;
});
    function deleteEmployee(empId){

        console.log(empId);
        fetch(`http://localhost:8080/employee/${empId}`, {
            method: 'DELETE',
        })
            .then(res => res.text()) // or res.json()
            .then(res => console.log(res))

        window.location.reload();
    }
    function editEmployee(empId){
        console.log(empId);
    }
