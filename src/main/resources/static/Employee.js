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
                         <a class="edit_btn" href="updateEmployee.html" onclick="editEmployee(${employee.employeeId})">Edit</a>
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
        window.Empid = empId;
    }
 function updateEmployee(e){

        const firstName = document.getElementById("fName").value;
        const lastName = document.getElementById("lName").value;
        const address = document.getElementById("addr").value;
        const phoneNumber = document.getElementById("phoneNum").value;
     let raw = "";

     let requestOptions = {
         method: 'PUT',
         body: raw,
         redirect: 'follow'
     };

     fetch(`http://localhost:8080/employee/16?firstName=${firstName}&lastName=${lastName}&address=${address}&phone=${phoneNumber}`, requestOptions)
         .then(response => response.text())
         .then(result => console.log(result))
         .catch(error => console.log('error', error));
 }

