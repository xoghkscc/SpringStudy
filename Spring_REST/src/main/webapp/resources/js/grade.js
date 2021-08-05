const table = document.getElementById("display");
const selectAll = document.getElementById("selectAll");
const insertBtn = document.getElementById("insertBtn");

selectAll.addEventListener('click', () => {
	const xhttp = new XMLHttpRequest();

	table.innerHTML = "<tr><th>학번</th><th>이름</th><th>성적</th><th>삭제</th></tr><tr><td><input type='hidden' /> </td><td><input type='text' id='name' autocomplete='off'/> </td><td><input type='text' id='grade'autocomplete='off' /> </td></tr>";

	xhttp.addEventListener('readystatechange', (e) => {
		const target = e.target;
		const status = target.status;
		const readyState = target.readyState;

		if (status == 200 && readyState == 4) {

			const myobj = JSON.parse(target.responseText);
			Object.keys(myobj).forEach((key) => {
				const new_node = document.createElement("tr");
				const new_node_button = document.createElement("button");

				Object.keys(myobj[key]).forEach((key2, index) => {
					const new_node2 = document.createElement("td");

					new_node2.innerHTML = myobj[key][key2];
					new_node.appendChild(new_node2);
					if (index == 0) {
						new_node_button.setAttribute('id', myobj[key][key2]);
						new_node_button.setAttribute('class', "delete");
					}
					if (index == 2) {
						new_node_button.innerHTML += '삭제';
						new_node.appendChild(new_node_button);
					}
				})
				new_node_button.addEventListener('click', deleteFunction)
				table.appendChild(new_node);
			})
		}
	})

	xhttp.open('GET', '/rest/crud_rest/getGrade', true)
	xhttp.send();
})


function deleteFunction() {
	const xhttp2 = new XMLHttpRequest();
	
	const student_id = {
		student_id: this.getAttribute('id')
	}

	xhttp2.open('POST', '/rest/crud_rest/deleteGrade', true)
	xhttp2.send(this.getAttribute('id'));
	selectAll.click();

}

insertBtn.addEventListener('click', (e) => {
	e.preventDefault();
	const insert = document.getElementById("insert");

	const xhttp = new XMLHttpRequest();

	const insertGrade = {
		student_name: insert.elements[1].value,
		grade: insert.elements[2].value
	}

	insert.elements[1].value = "";
	insert.elements[2].value = "";

	xhttp.addEventListener('readystatechange', (e) => {
		const target = e.target;
		const status = target.status;
		const readyState = target.readyState;

	})
	xhttp.open('POST', '/rest/crud_rest/insertGrade', true);
	xhttp.setRequestHeader('content-type', 'application/json;charset=utf-8');

	xhttp.send(JSON.stringify(insertGrade));
})

