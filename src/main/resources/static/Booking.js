fetch("http://localhost:8080/booking")

    .then(response => response.json())
    .then(json => {

        let li = `<tr>
        <th>Booking Id</th>
        <th>Name</th>
        <th>Adults</th>
        <th>Kids</th>
        <th>Room Type</th>
        <th>Check In </th>
        <th>Check Out</th>
        <th>Action</th>
    </tr>`;

        json.forEach(booking => {
            li += `<tr>
                <td>${booking.guestId} </td>
                <td>${booking.name} </td>
                <td>${booking.adults}</td>
                <td>${booking.kids}</td>
                 <td>${booking.roomType}</td>
                <td>${booking.checkIn}</td>
                <td>${booking.checkOut}</td>
               
                 <td>
                         <button class="edit_btn" onclick="editBooking(${booking.guestId})">Edit</button>
                        <button class="delete_btn" onclick="deleteBooking(${booking.guestId})">Delete</button>
        </td>
            </tr>`;
        });
        document.getElementById("booking").innerHTML = li;
    });
function deleteBooking(guestId){
    console.log(guestId);
    fetch(`http://localhost:8080/booking/${guestId}`, {
        method: 'DELETE',
    })
        .then(res => res.text()) // or res.json()
        .then(res => console.log(res))

    window.location.reload();
}
function editBooking(guestId){
    console.log(guestId);
}
