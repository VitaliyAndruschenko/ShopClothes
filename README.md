# ShopClothes
The website of a clothing store based on Spring MVC.All the main technologies were used, as well as integration with the payment system was carried out.The Actulator is used for better data collection, and Spring Admin is also connected.

## Используемые технологии:
Java, Maven, Hibernate, JPA, Spring Framework, Spring Sequrity, Spring Actulator, OAuth2, PayU, JUnit, Thylmeaf, PostgreSQL HTML, CSS, JavaScript.
### Начало работы
### 1.Введите localhost:8080/ Вы увидите приветственную страницу.

![images](/images/1.png)

### 2. Занесенные в базу тестовые товары отобразятся ниже по странице или если щелкнуть по вкладке products.

![images](/images/2.png)

### 3. Товары сортированы по возрастанию и поделены на постраничный вывод

### 4. Views полностью отзывчивый, и кликнув на карточку товара сайт перебросит вас на карточку товара.

![images](/images/3.png)

### 5. Нажав на кнопку добавления сервис предложит вам авторизоваться, так как заказать товар могут только зарегистрированные пользователи с ролью USER 

![images](/images/4.png)

### 6.Далее необходимо проследовать по указателю регистрации и пройти короткую регистрацию или воспользоваться OAuth2 авторизацией после чего вам будет доступна возможность добавить товар в корзину и сделан кук.

![images](/images/5.png)

### 7. Так будет выглядеть корзина покупок со всех необходимой информацией

![images](/images/6.png)

### 8. После заполнения email и номера телефона запись о заказе уходит в базу не сервер и (сервис для платежной системы готов) осталось только прикрепить ссылку контроллера на кнопку.Корзина выполнена в сессии после оформления заказа очищается.

![images](/images/7.png)

### 9. На вкладке Contact вас будет ждать форма обратной связи при она сопряжена с каждый юзером поэтому если вы все еще не зарегистрировались сервис вежливо попросит вас это сделать.

![images](/images/8.png)

### 10. Страница администратора с общим функционалом всего сервиса реализована по адресу localhost:8080/office и доступна только администратору который заносится в базу данных во время инициализации проекта (Логин:Test Пароль:Admin)

### 11. Если кликнуть на иконку человечка вы попадете на страницу profile с информацией о зарегистрированном юзере (возможностью сделать logout) и изменить личную информацию

![images](/images/9.png)