const to_print = document.querySelector("h4");


function loadStr() {
	//	1. �񵿱� ��û �ν��Ͻ� ����
	const xhttp = new XMLHttpRequest();

	//	2. �񵿱� ��û ����
	xhttp.onreadystatechange = (e) => {
		const target = e.target;
		const httpStatus = e.target.status;
		const readyState = e.target.readyState;

		console.log(target);
		console.log(readyState);
		if (httpStatus == 200) {
			if (readyState == 1) {
				to_print.innerHTML = '�������� ������ �����Ǿ����ϴ�.';
			} else if (readyState == 2) {
				to_print.innerHTML = '������ �� ��û�� �޾ҽ��ϴ�';
			} else if (readyState == 3) {
				to_print.innerHTML = '��û�� ó�����Դϴ�.';
			} else if (readyState == 4) {
				to_print.innerHTML = '��û ó���� ���� �� ������ �غ�Ǿ����ϴ�.';
			} else {
				to_print.innerHTML = '��û�� ���� �������� �ʾҰų� ���� �߸��Ǿ����ϴ�.';
			}
		}

	}

	xhttp.open('GET', '/rest/sample/getstr', true);

	xhttp.send();
}

const sampleAsyncBtn = document.getElementById("sampleAsyncBtn");
const testList = document.getElementById("testList")

sampleAsyncBtn.addEventListener('click', () => {
	const xhttp = new XMLHttpRequest();

	//	�񵿱� ��û�� ���� ���°� ��ȭ�Ҷ����� �߻��ϴ� �̺�Ʈ
	xhttp.addEventListener('readystatechange', (e) => {
		const target = e.target;
		const status = target.status;
		const readyState = target.readyState;

		if (status == 200 && readyState == 4) {
			//�ڹٽ�ũ��Ʈ������ ���� ���� JSON ������ ���ڿ��� Object�� ��ȯ�� �� �ִ�
			myobj = JSON.parse(target.responseText);

			console.log(myobj);

			Object.keys(myobj).forEach((key) => {
				const new_node = document.createElement("li");
				new_node.innerHTML = myobj[key];
				testList.appendChild(new_node);
			})
		}
	});
	//	�񵿱� ��û�� method�� uri�� ����
	xhttp.open('GET', '/rest/sample/getSample', true);
	xhttp.send();
})

const asyncJsonDataBtn = document.getElementById("asyncJsonDataBtn");
asyncJsonDataBtn.addEventListener('click', () => {
	const xhttp = new XMLHttpRequest();

	xhttp.addEventListener('readystatechange', (e) => {
		const target = e.target;
		const status = target.status;
		const readyState = target.readyState;


		if (status == 200 && readyState == 4) {
			to_print.innerHTML = target.responseText;
		}
	})
	const myFruit = {
		name: '���ξ���',
		price: 4500,
		calorie: 800
	}

	//GET������� �����͸� ���� ���� open() �޼����� URI �ڿ� �����͸� �ٿ��� ����
	//POST������� �����͸� ���� ���� send() �޼����� �Ű������� �����͸� �����Ѵ�
	xhttp.open('POST', '/rest/sample/fruit', true);
	xhttp.setRequestHeader('content-type', 'application/json;charset=utf-8');

	// �ڹٽ�ũ��Ʈ ������Ʈ�� ���� �ս��� JSON ���� ���ڿ��� ��ȯ�� �� �ִ�.
	xhttp.send(JSON.stringify(myFruit));
})

















