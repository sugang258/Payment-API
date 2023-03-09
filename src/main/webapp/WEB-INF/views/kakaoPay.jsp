<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>    
    <script>
        var IMP = window.IMP; 
        IMP.init("imp11225448"); 
    
        function requestPay() {
            IMP.request_pay({
                pg : 'kakaopay',
                pay_method : 'card',
                merchant_uid: "57008833-334", 
                name : '당근 10kg',
                amount : 100,
                buyer_email : 'Iamport@chai.finance',
                buyer_name : 'sugang',
                buyer_tel : '010-1234-5678',
                buyer_addr : '경기도 수원시',
                buyer_postcode : '123-456'
            }, function (rsp) { // callback
                if (rsp.success) {
                    console.log(rsp);
                } else {
                    console.log(rsp);
                }
            });
        }
    </script>
    <title>KakaoPay</title>
</head>
<body>
    <button onclick="requestPay()">결제하기</button>
</body>
</html>