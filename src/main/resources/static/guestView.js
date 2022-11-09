let requstOptions = {
    method: 'GET',
    redirect: 'follow'
};

fetch("http://localhost:8080/guest", requstOptions)

    .then(response => response.json())
    .then(json => {

        let li = `<tr>
        <th>ID</th>
        <th>E-mail</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Country</th>
        <th>Mobile</th>
         <th>Password</th>
        <th>Action</th>
    </tr>`;

        json.forEach(guest => {
            li += `<tr>
                <td>${guest.id} </td>
                <td>${guest.email}</td>
                <td>${guest.firstName} </td>
                <td>${guest.lastName}</td>          
                <td>${guest.country}</td>
                <td>${guest.mobile}</td>
                <td>${guest.password}</td>
                 <td>
                          <a class="edit_btn" href="updateGuest.html" onclick="editGuest(${guest.id})">Edit</a>
                        <button class="delete_btn" onclick="deleteGuest(${guest.id})">Delete</button>
        </td>
            </tr>`;
        });
        document.getElementById("guestTable").innerHTML = li;
    });
function deleteGuest(id){

    console.log(id);
    fetch(`http://localhost:8080/guest/${id}`, {
        method: 'DELETE',
    })
        .then(res => res.text()) // or res.json()
        .then(res => console.log(res))

    window.location.reload();
}
function editGuest(id){
    sessionStorage.setItem("id",id);
}
//
// function updateGuest(e){
//
//     const firstName = document.getElementById("firstName").value;
//     const lastName = document.getElementById("lastName").value;
//     const country = document.getElementById("country").value;
//     const Mobile = document.getElementById("Mobile").value;
//     const Password = document.getElementById("Password").value;
//     let raw = "";
//
//     let requestOptions = {
//         method: 'PUT',
//         body: raw,
//         redirect: 'follow'
//     };
//
//     fetch(`http://localhost:8080/guest/16?firstName=${firstName}&lastName=${lastName}&country=${country}&Mobile=${Mobile}&Password=${Password}`, requestOptions)
//         .then(response => response.text())
//         .then(result => console.log(result))
//         .catch(error => console.log('error', error));
// }
//
