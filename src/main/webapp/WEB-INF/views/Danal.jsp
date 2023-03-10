<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
                    pg : 'danal_tpay',
                    pay_method : 'card',
                    merchant_uid: "57008833-3344", 
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

            function requestPhonePay() {
                IMP.request_pay({
                    pg : 'danal',
                    pay_method : 'phone',
                    merchant_uid: "57008833-334433", 
                    name : '다날 휴대폰 결제',
                    amount : 100,
                    buyer_email : 'Iamport@chai.finance',
                    buyer_name : 'sugang',
                    buyer_tel : '010-1234-5678',
                    buyer_addr : '경기도 수원시',
                    buyer_postcode : '123-456',
                    biz_num : '1234567890' //휴대폰 결제 시, 필수 입력
                }, function (rsp) { // callback
                    if (rsp.success) {
                        console.log(rsp);
                    } else {
                        console.log(rsp);
                    }
                });
            }
        </script>
        
    <title>Danal</title>
</head>
<body>
    <button onclick="requestPay()">결제하기</button>
    <button onclick="requestPhonePay()">휴대폰결제</button>
    
</body>
</html>