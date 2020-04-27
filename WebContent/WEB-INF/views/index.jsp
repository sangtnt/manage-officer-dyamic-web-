<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
		display: flex;
		justify-content: space-between;
		height: 100vh;
		overflow: hidden;
	}
	.table-officer{
		flex-grow: 1;
		margin-right: 200px;
	}
	.table-officer, .table-officer th, .table-officer td {
  		border: 1px solid black;
  		cursor: pointer;
	}
	.invalid-btn{
		pointer-events: none; 
		opacity: 0.5;
	}
	.action{
		border: 1px dotted black;
		padding: 20px;
		border-radius: 5px;
	}
	.prop{
		display: none;
	}
	.address{
		width: 200px
	}
	.object:hover{
		background :#b5ffee;
	}
	thead{
		background: #b3b3b3;
	}
</style>
</head>
<body>
	<table class="table-officer">
		<caption><h2>Officers info</h2></caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>Full name</th>
				<th>Age</th>
				<th>Sex</th>
				<th class="address">Address</th>
				<th colspan="2">Job</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="officer" items="${officers}">
				<tr class="object">
					<td>${officer.id}</td>
					<td>${officer.fullname}</td>
					<td>${officer.age}</td>
					<td>${officer.sex }</td>
					<td>${officer.address }</td>
					<td>${officer.job }</td>
					<td>${officer.jobProp}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form method="post">
		<table class="action">
			<tr>
				<td colspan="2"><span style="color: red">${message }</span></td>
			</tr>
			<caption><h3 class="title-action">Add Officer</h3></caption>
			<tr>
				<td><input id="id" type="text" name="id" class="id" hidden/></td>
			</tr>
			<tr>
				<td>Fullname: </td>
				<td><input id="fullname" type="text" name="fullname" class="fullname" required/></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input id="age" type="number" name="age" class="age" required/></td>
			</tr>
			<tr>
				<td>Sex:</td>
				<td>
					<input id="male" name="sex" type="radio" value="male" required/> Male
					<input id="female" name="sex" type="radio" value="female" required/> Female
					<input id="other" name="sex" type="radio" value="other" required/> Other
				</td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input id="address" type="text" name="address" required/></td>
			</tr>
			<tr>
				<td>Job:</td>
				<td>
					<select name="job" id="job" required>
						<option value="worker">Worker</option>
						<option value="engineer">Engineer</option>
						<option value="staff">Staff</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Job property:</td>
				<td>
					<select name="worker" id="worker">
						<option value="level 1">Level 1</option>
						<option value="level 2">Level 2</option>
						<option value="level 3">Level 3</option>
						<option value="level 4">Level 4</option>
						<option value="level 5">Level 5</option>
					</select>
					<select name="engineer" id="engineer" class="prop">
						<option value="Bridge engineer">Bridge engineer</option>
						<option value="Software engineer">Software engineer</option>
						<option value="Biomedical engineer">Biomedical engineer</option>
						<option value="Structural engineer">Structural engineer</option>
						<option value="Electrical engineer">Electrical engineer</option>
					</select>
					<select name="staff" id="staff" class="prop">
						<option>Project manager</option>
						<option>Leader</option>
						<option>Backend dev</option>
						<option>Fullstack dev</option>
						<option>Frontend dev</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="border-top:1px black dotted;text-align: center" colspan="2">
					<button class="add-btn" 
							type="submit"
							formaction="AddServlet"
					>Add
					</button>
					<button class="update-btn invalid-btn" 
							type="submit"
							formaction="UpdateServlet"
					>Edit
					</button>
					<button class="update-btn invalid-btn" 
							type="submit"
							formaction="DeleteServlet"
					>Delete
					</button>
					<button id="reset"
						 type="reset"
					>Reset
					</button>
				</td>
			</tr>
		</table>
	</form>
	<script>
		var elements=document.getElementsByClassName("object");
		var myFunction = function(){
			var children= this.children;
			document.getElementById("id").value=children[0].innerHTML;
			document.getElementById("fullname").value=children[1].innerHTML;
			document.getElementById("age").value=children[2].innerHTML;
			document.getElementById(children[3].innerHTML).checked=true;
			document.getElementById("address").value=children[4].innerHTML;
			document.getElementById("job").value=children[5].innerHTML;
			document.getElementsByClassName("update-btn")[0].classList.remove("invalid-btn");
			document.getElementsByClassName("update-btn")[1].classList.remove("invalid-btn");
			document.getElementsByClassName("add-btn")[0].classList.add("invalid-btn");
			document.getElementById(document.getElementById("job").value).value=children[6].innerHTML;
			
			document.getElementById("worker").classList.add("prop");
			document.getElementById("engineer").classList.add("prop");
			document.getElementById("staff").classList.add("prop");
			var value=document.getElementById("job").value;
			document.getElementById(value).classList.remove("prop");
		};
		for (var i = 0; i < elements.length; i++) {
		    elements[i].addEventListener('click', myFunction, false);
		}
		document.getElementById("job").addEventListener('change', function(){
			document.getElementById("worker").classList.add("prop");
			document.getElementById("engineer").classList.add("prop");
			document.getElementById("staff").classList.add("prop");
			var value=document.getElementById("job").value;
			document.getElementById(value).classList.remove("prop");
		});
		document.getElementById("reset").addEventListener('click', function(){
			if (document.getElementsByClassName("add-btn")[0].classList.contains("invalid-btn")){
				document.getElementsByClassName("update-btn")[0].classList.add("invalid-btn");
				document.getElementsByClassName("update-btn")[1].classList.add("invalid-btn");
				document.getElementsByClassName("add-btn")[0].classList.remove("invalid-btn");
			}
		})
	</script>
</body>
</html>