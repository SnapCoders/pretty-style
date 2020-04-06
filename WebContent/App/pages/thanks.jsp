<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="../styles/catalog-myproducts-thanks.css" rel="stylesheet">
    <script src="../lib/bootstrap/js/bootstrap.min.js"></script>
    <title>PrettyStyle</title>
</head>
<body>
    <main>
        <section id="meusPedidos" class="">
            <div id="titleLine">
                <hr class="my-4">
            </div>
            <div class="jumbotron bg-white" id="div-thanks">
                <div id="thanks">
                    <h3 class="color-blue">Obrigado por efetuar sua compra na PrettyStyle!</h3>
                </div>
                <div class="container" id="confirm">
                    <svg xmlns="http://www.w3.org/2000/svg" id="img-right" width="100" height="80px"
                        viewBox="0 0 144.697 128">
                        <g id="Grupo_136" data-name="Grupo 136" transform="translate(-466 -439)">
                            <circle id="Elipse_14" data-name="Elipse 14" cx="64" cy="64" r="64"
                                transform="translate(466 439)" fill="#00ff43" />
                            <path id="check"
                                d="M44.83,90a6.274,6.274,0,0,1-4.448-1.843L1.846,49.617a6.291,6.291,0,0,1,8.9-8.9L44.83,74.809,117.457,2.184a6.291,6.291,0,0,1,8.9,8.9L49.279,88.155A6.277,6.277,0,0,1,44.83,90Zm0,0"
                                transform="translate(481 450.007)" fill="#fff" stroke="#00ff43" stroke-width="3" />
                        </g>
                    </svg>
                    <strong id="msg-receber-pedido">Recebemos seu pedido</strong>
                </div>
                <div class="container" id="body-thanks">
                    <strong class="color-blue fsize-1-4em">Olá, Bruno Amaral Futema.</strong>
                    <div class="pt-5">
                        <p id=bt-p>Agradecemos sua preferência pelo PrettyStyle!</p>
                        <p id=bt-p>A partir de agora, você será informado(a) por e-mail sobre o andamento do seu pedido
                            até a chegada no endereço escolhido.</p>
                    </div>
                    <div id="nPedido">
                        <p id="pedido-p">Número do seu pedido</p>
                        <p id="codigoPedido">03-747ed29f-c4ef-4a25-876e-3f249ec5ae31</p>
                    </div>
                    <div id="img-status">
                        <!-- <img src="/icons/Grupo 143.svg" alt=""> -->
                        <div class="corpo">
                            <div class="step-all">
                                <p class="step-name">Pedido <br>Realizado</p>
                                <div class="step">
                                    <p class="step-number">1</p>
                                </div>
                            </div>
                            <div class="step-all">
                                <p class="step-name">Aprovação<br>de pagamento</p>
                                <div class="step">
                                    <p class="step-number">2</p>
                                </div>
                            </div>
                            <div class="step-all">
                                <p class="step-name">Produto(s) em<br>transporte</p>
                                <div class="step">
                                    <p class="step-number">3</p>
                                </div>
                            </div>
                            <div class="step-all">
                                <p class="step-name">Produto(s)<br>entregue(s)</p>
                                <div class="step">
                                    <p class="step-number">4</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>
</html>