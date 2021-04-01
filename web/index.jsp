
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header>
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-8">
            <div class="cover">
                <div class="main-header">
                    <h1>Большой и красивый заголовок</h1>
                    <p>
                        Место для небольшого объяснения (рекламного слогана)- кто мы, 
                        о чем сайт и зачем мы все это затеяли. 
                        Что-то особенное, что может заинтересовать за пару фраз. 
                    </p>
                    <button type="button">Подробнее</button>
                    <a href="price"><button type="button">Прайс-лист</button></a>
                </div>
            </div>
        </div>
    </div>
</header>
<section class="about">
    <a name="about"></a>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <img class="rounded-circle" src="css/images/me.jpg">
                <h3>Кто я?</h3>
                <p>Я - вся такая молодец, ну просто супер! Вы и представить себе не могли,
                    что есть такой замечательный мастер и совсем рядом с вами. <br>
                    Училась я в Питербурге, работаю не одну тысячу лет. За все время никому еще пальцев не отрезала,
                    так что, приходите, не стесняйтесь. Будьте уверены, что ваши ручки/ножки в надежных руках.
                    И пусть все девченки на деревне обзавидуются. И т.д в том же духе)))</p>
            </div>
        </div>
    </div>
</section>
<section class="service">
    <a name="service"></a>
    <div class="row">
        <div class="col-md-6">
            <div class="serv-box">
                <h3>Услуги</h3>
                <p>Я предоставляю такие-то услуги. Все делаю профессионально и из качественных материалов, откуда и такая цена. Подробнее с ценами можно ознакомиться перейдя по ссылке ниже. </p>
                <a href="price"><button type="button">Прайс-лист</button></a>
            </div>
        </div>
        <div class="col-md-6">
            <div class="man">
                <img src="css/images/capture_4.jpg">
                    <div class="note">
                        <h4>Маникюр</h4>
                    </div>
            </div>
            <div class="ped">
                <img src="css/images/ped.jpg">
                    <div class="note">
                        <h4>Педикюр</h4>
                    </div>
                </div>
            <div class="dep">
                <img src="css/images/dep.jpg">
                    <div class="note">
                        <h4>Депиляция</h4>
                    </div>
            </div>
        </div>
    </div>
</section>
<!--galery-->
<section class="contact">
    <a name="contact"></a>
    <div class="cont-fliud">
        <div class="row">
            <div class="col-md-6">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d129708.06556283869!2d24.598160230333242!3d59.471618073611054!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46929499df5616bf%3A0x400b36d18fc6270!2z0KLQsNC70LvQuNC9!5e0!3m2!1sru!2see!4v1614102946979!5m2!1sru!2see" allowfullscreen="" loading="lazy"></iframe>
            </div>
            <div class="col-md-6">
                <div class="cont-box">
                    <h4>Контакты</h4>
                    <p class="cont-info">
                        Найти меня очень просто (стоит только посмотреть на карту слева). Но вот вам еще визитка
                    </p>
                    <div class="cont-card">
                        <p>
                            Ahtme, Väike-äike 25-35<br>
                            nails@nails.ee<br>
                            Телефон +123456789
                        </p>
                    </div>
                </div>	
            </div>
        </div>
    </div>
</section>
<section class="feedback">
    <a name="feedback"></a>
    <div class="row">
        <div class="col-md-6">
            <div class="feed-info">
                <h4>Форма обратной связи</h4>
                <p>
                        Вы можете записаться на прием по телефону, лично или написав на электронную почту - любым удобным для вас способом. Вы также можете написать мне с помощью формы обратной связи слева.
                </p>
            </div>
        </div>
        <div class="col-md-6">
            <form>
                <input class="top-input" type="text" name="name" placeholder="Ваше имя" required>
                <input type="text" name="email" placeholder="Электронный адрес" required>
                <textarea name="message" placeholder="Ваше сообщение" required></textarea>
                <button type="submit" name="submit">Отправить</button>
            </form>
        </div>
    </div>
</section>
<section class="the-end">
    <div class="row">
        <div class="col-md-12">
            <div class="end-card">
                <h2>Жду вас с нетерпением!</h2>
            </div>
        </div>
    </div>
</section>