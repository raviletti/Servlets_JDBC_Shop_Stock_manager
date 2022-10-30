<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous">
<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        /* Кнопка, используемая для открытия контактной формы-фиксируется в нижней части страницы */
        .open-button {
            background-color: #000000;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            opacity: 0.8;
            position: fixed;
            bottom: 23px;
            right: 28px;
            width: 150px;
        }

        .open-button-buy {
            background-color: #000000;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            opacity: 0.8;
            position: fixed;
            bottom: 90px;
            right: 28px;
            width: 150px;
        }

        /* Всплывающая форма-скрыта по умолчанию */
        .form-popup {
            display: none;
            position: fixed;
            bottom: 0;
            right: 21px;
            border: 3px solid #f1f1f1;
        }

        .form-popup-buy {
            display: none;
            position: fixed;
            bottom: 0;
            right: 115px;
            border: 3px solid #f1f1f1;
        }

        /* Добавление стилей в контейнер форм */
        .form-container {
            max-width: 280px;
            padding: 10px;
            background-color: white;
        }
        /* Поля ввода полной ширины */
        .form-container input[type=text], .form-container input[type=password] {
            width: 100%;
            padding: 8px;
            margin: 5px 0 10px 0;
            border: none;
            background: white;
            outline: 1px solid #808080;
        }
        /* Когда входы получают фокус, сделайте что-нибудь */
        .form-container input[type=text]:focus, .form-container input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }
        /* Установите стиль для кнопки отправить/кнопка */
        .form-container .btn {
            background-color: #000000;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            width: 100%;
            margin-bottom:10px;
            opacity: 0.8;
        }
        /* Добавьте красный цвет фона к кнопке отмена */
        .form-container .cancel {
            background-color: #000000;
        }
        /* Добавьте некоторые эффекты наведения на кнопки */
        .form-container .btn:hover, .open-button:hover {
            opacity: 1;
        }
        .colortext {
            background-color: white; /* Цвет фона */
        }
    </style>
</head>
<body>


<button class="open-button-buy" onclick="openForm()">Buy</button>
<button class="open-button" onclick="openForm()">Contact us</button>
<div class="form-popup" id="myForm">
    <form action="/Contact" method="post" class="form-container">
        <%--@declare id="email"--%><%--@declare id="name"--%><%--@declare id="phone"--%><h1>Contact Us</h1>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Email" name="email" required>

            <label for="name"><b>Name</b></label>
            <input type="text" placeholder="Name" name="name" required>

            <label for="phone"><b>Phone number</b></label>
            <input type="number" placeholder="Phone number" name="phone" required>



        <label required><b>Message</b></label><textarea rows="5" cols="30" type="text" placeholder="Type message" name="message" class="colortext" required></textarea>


        <button type="submit" class="btn">Send</button>
        <button type="button" class="btn cancel" onclick="closeForm()">Close</button>

    </form>
</div>

<script>
    function openForm() {
        document.getElementById("myForm").style.display = "block";
    }

    function closeForm() {
        document.getElementById("myForm").style.display = "none";
    }
</script>

</body>
</html>



