const to_print = document.querySelector("h4");


function loadStr() {
	//	1. 비동기 요청 인스턴스 생성
	const xhttp = new XMLHttpRequest();

	//	2. 비동기 요청 생성
	xhttp.onreadystatechange = (e) => {
		const target = e.target;
		const httpStatus = e.target.status;
		const readyState = e.target.readyState;

		console.log(target);
		console.log(readyState);
		if (httpStatus == 200) {
			if (readyState == 1) {
				to_print.innerHTML = '서버와의 연결이 수립되었습니다.';
			} else if (readyState == 2) {
				to_print.innerHTML = '서버가 내 요청을 받았습니다';
			} else if (readyState == 3) {
				to_print.innerHTML = '요청을 처리중입니다.';
			} else if (readyState == 4) {
				to_print.innerHTML = '요청 처리가 끝난 후 응답이 준비되었습니다.';
			} else {
				to_print.innerHTML = '요청이 아직 생성되지 않았거나 뭔가 잘못되었습니다.';
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

	//	비동기 요청에 대한 상태가 변화할때마다 발생하는 이벤트
	xhttp.addEventListener('readystatechange', (e) => {
		const target = e.target;
		const status = target.status;
		const readyState = target.readyState;

		if (status == 200 && readyState == 4) {
			//자바스크립트에서는 아주 쉽게 JSON 형식의 문자열을 Object로 변환할 수 있다
			myobj = JSON.parse(target.responseText);

			console.log(myobj);

			Object.keys(myobj).forEach((key) => {
				const new_node = document.createElement("li");
				new_node.innerHTML = myobj[key];
				testList.appendChild(new_node);
			})
		}
	});
	//	비동기 요청에 method와 uri를 설정
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
		name: '파인애플',
		price: 4500,
		calorie: 800
	}

	//GET방식으로 데이터를 보낼 때는 open() 메서드의 URI 뒤에 데이터를 붙여서 전송
	//POST방식으로 데이터를 보낼 때는 send() 메서드의 매개변수로 데이터를 전송한다
	xhttp.open('POST', '/rest/sample/fruit', true);
	xhttp.setRequestHeader('content-type', 'application/json;charset=utf-8');

	// 자바스크립트 오브젝트는 아주 손쉽게 JSON 형식 문자열로 변환될 수 있다.
	xhttp.send(JSON.stringify(myFruit));
})

















