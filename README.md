# lab17
**Звіт з лабараторної роботи №17 **

Програма реалізує функції телефонного довідника, використовуючи мову програмування Java та базу даних PostgreSQL. Основний функціонал програми полягає в додаванні, оновленні, видаленні та відображенні контактів.

**Опис коду:**

У програмі використовуються три класи:

1. `Main`: Головний клас, що містить метод `main`. У цьому класі відбувається основний виклик методів телефонного довідника.

2. `ContactDAO`: Клас, який відповідає за доступ до бази даних. В ньому здійснюються операції додавання, оновлення, видалення та відображення контактів у базі даних.

3. `DatabaseConnector`: Клас, який надає з'єднання з базою даних. Він містить методи для встановлення з'єднання, закриття з'єднання, закриття запиту та закриття результату запиту.

**Використання програми:**

Після запуску програми користувачу пропонується меню з наступними опціями:
1. Додати контакт.
2. Оновити контакт.
3. Видалити контакт.
4. Відобразити всі контакти.
5. Вийти з програми.

Користувач обирає опцію, вводить відповідні дані (наприклад, ім'я, номер телефону, електронну пошту) і програма виконує відповідну операцію з базою даних.

<img width="260" alt="Знімок екрана 2024-05-16 о 17 20 16" src="https://github.com/MatrixRosul/lab17/assets/147719806/f62df451-06d0-4ae3-81ab-8392e7951b54">

<img width="394" alt="Знімок екрана 2024-05-16 о 17 20 40" src="https://github.com/MatrixRosul/lab17/assets/147719806/e48b28d8-c107-4806-8e14-33e8f312502e">

<img width="362" alt="Знімок екрана 2024-05-16 о 17 20 50" src="https://github.com/MatrixRosul/lab17/assets/147719806/3cdf3713-64d4-460b-bc82-29b50f4eb594">

**Висновок:**

Програма "Телефонний довідник" демонструє використання мови програмування Java разом з базою даних PostgreSQL для створення простого, але ефективного інструменту управління контактами. Вона дозволяє користувачам додавати, оновлювати, видаляти та відображати контакти, забезпечуючи зручність та ефективність в роботі з інформацією про контакти.
