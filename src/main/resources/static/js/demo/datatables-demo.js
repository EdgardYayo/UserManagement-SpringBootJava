// Call the dataTables jQuery plugin
$(document).ready(function() {
  getUsers();
  $('#dataTable').DataTable();
});


const getUsers = async () => {
  const request = await fetch("http://localhost:8080/user/55", {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const response = await request.json();

  console.log(response);

}