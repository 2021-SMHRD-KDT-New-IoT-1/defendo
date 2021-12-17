<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" type="text/css" href="styles/JoinPage_style.css">
</head>

<body class="align">

   <div class="grid">
 
     <form action="../Join" method="POST" class="form login">
 
      <div class="text--center">
         <h1>JOIN US</h1>
      </div>

      <div class="form__field">
         <label for="login__username">
            <svg class="icon">
             <use xlink:href="#icon-user"></use>
            </svg>
           <span class="hidden">id</span>
         </label>
         <input autocomplete="username" id="username" type="text" name="id" class="form__input" placeholder="아이디를 입력하세요" required="required">
       </div> 



       <div class="form__field">
         <input type="button" value="ID Check" onclick="idCheck();" required="required" >
        
       </div>
          <div class="form__field">
         <span id="sp_result">아이디 중복체크를 해주세요!</span>
       </div>
       

       <div class="form__field">
         <label for="login__password">
            <svg class="icon">
             <use xlink:href="#icon-lock"></use>
            </svg>
           <span class="hidden">pw</span>
         </label>
         <input id="login__password" type="password" name="password" class="form__input" placeholder="비밀번호를 입력하세요" required>
       </div>
 
       <div class="form__field">
         <label for="login__username">
            <svg class="icon">
             <use xlink:href="#icon-name"></use>
            </svg>
           <span class="hidden">name</span>
         </label>
         <input autocomplete="username" id="login__username" type="text" name="name" class="form__input" placeholder="이름을 입력하세요" required>
       </div>

       <div class="form__field">
         <label for="login__username">
            <svg class="icon">
             <use xlink:href="#icon-tel"></use>
            </svg>
           <span class="hidden">tel</span>
         </label>
         <input autocomplete="username" id="login__username" type="text" name="tel" class="form__input" placeholder="전화번호를 입력하세요" required>
       </div>

       <div class="form__field">
         <label for="login__username">
            <svg class="icon">
             <use xlink:href="#icon-dept"></use>
            </svg>
           <span class="hidden">dept</span>
         </label>
         <input autocomplete="username" id="login__username" type="text" name="dept" class="form__input" placeholder="소속을 입력하세요" required>
       </div>


       <!-- 체크박스 -->
       <div class="container">
        <label for="cbtest" id="check_manager">관리자 체크</label>
        <input type="checkbox" id="cbtest" name="check_manager" value="Y"/>
        <label for="cbtest" class="check-box" ></label> 
       </div>

       <div class="form__field">
         <input type="submit" value="Sign In">
       </div>
     </form>
 
      <p class="text--center">
        
        <svg class="icon">
         <use xlink:href="#icon-arrow-right"></use>
       </svg>
       <a href="Login.html">로그인</a> 
      </p>

      <p class="text--center">
         
        <svg class="icon">
         <use xlink:href="#icon-arrow-right"></use>
       </svg>
       <a href="index_before.html">메인화면으로</a>
      </p>
 
   </div>

  <script>
	function idCheck() {
		
		var input = document.getElementById("username");
		
		$.ajax({
			type : "post", // 데이터 전송(요청) 방식
			data : {"id": input.value}, // 전송하는 데이터
			url : "idCheck", // 데이터를 전송하는 (요청하는) 서퍼페이지 url
			dataType : "text", // 응답 데이터의 형식
			success : function(data) { //통신 성공
				
				var sp_result = document.getElementById("sp_result");

				
				if(data=="true"){
						
					sp_result.innerText = "사용불가능한 아이디";
			
					alert("사용불가능한 아이디");
				}else{
					
					sp_result.innerText = "사용가능한 아이디";
			
					alert("사용가능한 아이디");
				}
				
				
			}, 
			error : function () { // 통신 실패
				alert("통신실패")
			}
								
		});

		}
	
  </script>
  
 
   <svg xmlns="http://www.w3.org/2000/svg" class="icons">
     <symbol id="icon-arrow-right" viewBox="0 0 24 24">
      ><path d="M12 13v7l-8-8 8-8v7h8v2z"/>
     </symbol>
     <symbol id="icon-lock" viewBox="0 0 1792 1792">
       <path d="M640 768h512V576q0-106-75-181t-181-75-181 75-75 181v192zm832 96v576q0 40-28 68t-68 28H416q-40 0-68-28t-28-68V864q0-40 28-68t68-28h32V576q0-184 132-316t316-132 316 132 132 316v192h32q40 0 68 28t28 68z" />
     </symbol>
     <symbol id="icon-user" viewBox="0 0 1792 1792">
       <path d="M1600 1405q0 120-73 189.5t-194 69.5H459q-121 0-194-69.5T192 1405q0-53 3.5-103.5t14-109T236 1084t43-97.5 62-81 85.5-53.5T538 832q9 0 42 21.5t74.5 48 108 48T896 971t133.5-21.5 108-48 74.5-48 42-21.5q61 0 111.5 20t85.5 53.5 62 81 43 97.5 26.5 108.5 14 109 3.5 103.5zm-320-893q0 159-112.5 271.5T896 896 624.5 783.5 512 512t112.5-271.5T896 128t271.5 112.5T1280 512z" />
     </symbol>
     <symbol id="icon-name" viewBox="0 0 24 24">
      <path d="M16 2l5 5v14.008a.993.993 0 0 1-.993.992H3.993A1 1 0 0 1 3 21.008V2.992C3 2.444 3.445 2 3.993 2H16zm-4 9.5a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5zM7.527 17h8.946a4.5 4.5 0 0 0-8.946 0z"/>
     </symbol>
     <symbol id="icon-tel" viewBox="0 0 24 24" >
      <path d="M21 16.42v3.536a1 1 0 0 1-.93.998c-.437.03-.794.046-1.07.046-8.837 0-16-7.163-16-16 0-.276.015-.633.046-1.07A1 1 0 0 1 4.044 3H7.58a.5.5 0 0 1 .498.45c.023.23.044.413.064.552A13.901 13.901 0 0 0 9.35 8.003c.095.2.033.439-.147.567l-2.158 1.542a13.047 13.047 0 0 0 6.844 6.844l1.54-2.154a.462.462 0 0 1 .573-.149 13.901 13.901 0 0 0 4 1.205c.139.02.322.042.55.064a.5.5 0 0 1 .449.498z"/>
     </symbol>
     <symbol id="icon-dept"  viewBox="0 0 24 24">
      <path d="M21 19h2v2H1v-2h2V4a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v15h2V9h3a1 1 0 0 1 1 1v9zM7 11v2h4v-2H7zm0-4v2h4V7H7z"/>
     </symbol>
   </svg>
 
<!-- icon을 svg을 이용함
       -->
  
 </body>
</html>