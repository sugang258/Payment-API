<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>    

    <title>KakaoPay</title>
</head>
<body>
    <button id="card_pay">원포트-카카오페이 결제하기</button>
    <form method="post" action="/kakaoPay">
        <button id="kakaoPay">카카오페이 결제하기</button>
    </form>

    <script type="text/javascript" src="/js/kakaoPay.js"></script>
</body>
</html>