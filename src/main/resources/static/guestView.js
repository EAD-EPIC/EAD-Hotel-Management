fetch("http://localhost:8080/guest")

    .then(response => response.json())
    .then(json => {

        let li = `<tr>
        <th>ID</th>
        <th>E-mail</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Country</th>
        <th>Mobile</th>
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
                
                 <td>
                         <button class="edit_btn" onclick= "editGuest(${guest.id});window.location.href='updateGuest.html'">Edit</button>
                        <button class="btn btn-success" onclick="deleteGuest(${guest.id})">Delete</button>
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
    console.log(id);

    fetch('http://localhost:8080/guest/${id}?', {
        method: 'PUT',
        redirect: 'follow'
    })
        .then(res => res.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}
