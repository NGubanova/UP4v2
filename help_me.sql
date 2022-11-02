SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `help_me`
--

-- --------------------------------------------------------

--
-- Структура таблицы `aviary`
--

CREATE TABLE `aviary` (
  `id` bigint(20) NOT NULL,
  `type` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `aviary`
--

INSERT INTO `aviary` (`id`, `type`) VALUES
(1, 'Открытый вольер'),
(2, 'kjp'),
(3, 'Закрытый вольер, открытого типа ');

-- --------------------------------------------------------

--
-- Структура таблицы `clas`
--

CREATE TABLE `clas` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `clas`
--

INSERT INTO `clas` (`id`, `name`) VALUES
(2, 'Земноводное'),
(4, 'Млекопитающие');

-- --------------------------------------------------------

--
-- Структура таблицы `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `employee`
--

INSERT INTO `employee` (`id`, `active`, `name`, `password`, `username`, `post_id`) VALUES
(1, b'1', 'Qwerty!1', '$2a$08$sny0XH4oEwI8vUbhp96YweE5oyUmvPfFeD6PJCqIiaNeR6hovjca2', 'Qwerty!1', NULL),
(2, b'1', 'IVAN', '$2a$08$.9d7lHsmzKuquNuEpjYc8eOJdiM204xZJvILrGx.uZv1qAcPZUNim', 'IVANIVAN', NULL),
(3, b'1', 'Петр', '$2a$08$ZSlf1/BqpBnjLauDjX1Bz.aIkF0QKwPzqJ7r34OLbfsS1yjkHroje', 'POTRPOTR', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `excursion`
--

CREATE TABLE `excursion` (
  `id` bigint(20) NOT NULL,
  `bookers` varchar(255) DEFAULT NULL,
  `date_time` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `programm_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `excursion`
--

INSERT INTO `excursion` (`id`, `bookers`, `date_time`, `phone`, `programm_id`) VALUES
(19, 'rrrrr', '2022-11-02T14:35', 89, 7),
(20, 'rrrrr', '2022-11-02T14:35', 7899, 7),
(21, 'rrrrr', '2022-11-02T14:35', 55, 7);

-- --------------------------------------------------------

--
-- Структура таблицы `food`
--

CREATE TABLE `food` (
  `id` bigint(20) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `food`
--

INSERT INTO `food` (`id`, `description`, `name`) VALUES
(17, 'Мясной рацион для хищных животных, которые любят полакомится Мясом. Кст, мясо очень вкусный продукты, особенно если пожарить на огне и добавить приправы', 'Мясной рацион'),
(23, 'Морепродукты', 'Океанский шведский стол');

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(34);

-- --------------------------------------------------------

--
-- Структура таблицы `kind`
--

CREATE TABLE `kind` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `clas_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `kind`
--

INSERT INTO `kind` (`id`, `name`, `clas_id`) VALUES
(3, 'ящерка', 2),
(4, 'Кошачьи', 4),
(5, 'Собачьи', 4);

-- --------------------------------------------------------

--
-- Структура таблицы `post`
--

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `post`
--

INSERT INTO `post` (`id`, `name`, `salary`) VALUES
(1, 'Экскурсовод', 50000),
(2, 'Волонтер', 0),
(3, 'Смотритель', -90000);

-- --------------------------------------------------------

--
-- Структура таблицы `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `product`
--

INSERT INTO `product` (`id`, `name`) VALUES
(11, 'Арбуз'),
(12, 'Апельсин'),
(13, 'Рыба'),
(14, 'Свинина'),
(15, 'Говядина'),
(16, 'Илья'),
(22, 'Моллюски');

-- --------------------------------------------------------

--
-- Структура таблицы `product_food`
--

CREATE TABLE `product_food` (
  `product_id` bigint(20) NOT NULL,
  `food_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `product_food`
--

INSERT INTO `product_food` (`product_id`, `food_id`) VALUES
(13, 17),
(14, 17),
(15, 17),
(13, 23),
(16, 23),
(22, 23);

-- --------------------------------------------------------

--
-- Структура таблицы `programm`
--

CREATE TABLE `programm` (
  `id` bigint(20) NOT NULL,
  `billet` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `programm`
--

INSERT INTO `programm` (`id`, `billet`, `description`, `name`, `price`) VALUES
(7, 456, 'err', 'ryt', 5556),
(8, 20, 'Поведите своих детей в аквариум, там классно', 'Аквариум', 2000),
(9, 14, 'Морозная пустошь и ее обитатели', 'Морозная пустыня', 4500);

-- --------------------------------------------------------

--
-- Структура таблицы `programm_terrain`
--

CREATE TABLE `programm_terrain` (
  `terrain_id` bigint(20) NOT NULL,
  `programm_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `programm_terrain`
--

INSERT INTO `programm_terrain` (`terrain_id`, `programm_id`) VALUES
(10, 7),
(32, 8),
(32, 9),
(33, 9);

-- --------------------------------------------------------

--
-- Структура таблицы `terrain`
--

CREATE TABLE `terrain` (
  `id` bigint(20) NOT NULL,
  `area` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `terrain`
--

INSERT INTO `terrain` (`id`, `area`, `description`, `name`, `type_id`) VALUES
(10, 555, 'ttt777777', 'Левffffff', 8),
(32, -2999, 'На данной части зоопарка находятся водоплавующие существа', 'Водяной бассейн', 31),
(33, 14000, 'Очень холодно', 'Холодный зной', 30);

-- --------------------------------------------------------

--
-- Структура таблицы `type`
--

CREATE TABLE `type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `type`
--

INSERT INTO `type` (`id`, `name`) VALUES
(8, 'Лев'),
(29, 'Тундра'),
(30, 'Тайга'),
(31, 'Вода');

-- --------------------------------------------------------

--
-- Структура таблицы `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `roles`) VALUES
(1, 'USER'),
(1, 'ADMIN'),
(2, 'USER'),
(3, 'ADMIN'),
(3, 'USER'),
(8, 'USER'),
(8, 'ADMIN'),
(9, 'USER'),
(1, 'USER'),
(2, 'USER'),
(3, 'ADMIN');

-- --------------------------------------------------------

--
-- Структура таблицы `zoo`
--

CREATE TABLE `zoo` (
  `id` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `height` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `aviary_id` bigint(20) DEFAULT NULL,
  `food_id` bigint(20) DEFAULT NULL,
  `kind_id` bigint(20) DEFAULT NULL,
  `terrain_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `zoo`
--

INSERT INTO `zoo` (`id`, `age`, `description`, `height`, `name`, `weight`, `aviary_id`, `food_id`, `kind_id`, `terrain_id`, `user_id`) VALUES
(4, 3, 'wtr', 2, 'wertyui', 34, 1, 17, 3, 10, 1),
(5, 14, 'Ну он лев, типо царь зверей, всё такое', 190, 'Лев', 34, 3, 17, 4, 10, 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `aviary`
--
ALTER TABLE `aviary`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `clas`
--
ALTER TABLE `clas`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcm3b9d5fiw8s6co7lkw8c0lbs` (`post_id`);

--
-- Индексы таблицы `excursion`
--
ALTER TABLE `excursion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdoys10p4ua5wrup37d7fq0918` (`programm_id`);

--
-- Индексы таблицы `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `kind`
--
ALTER TABLE `kind`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhxennnt88s33rv7b9d0xd7ktb` (`clas_id`);

--
-- Индексы таблицы `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `product_food`
--
ALTER TABLE `product_food`
  ADD KEY `FKg7vkckaooo7vccith2syxesyv` (`food_id`),
  ADD KEY `FKd4eh78hi57ijn1isixj714lq9` (`product_id`);

--
-- Индексы таблицы `programm`
--
ALTER TABLE `programm`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `programm_terrain`
--
ALTER TABLE `programm_terrain`
  ADD KEY `FKeqt3cgjxti6etxovg5mcfribi` (`programm_id`),
  ADD KEY `FK311s1v5rkn51fpxeienm71cuk` (`terrain_id`);

--
-- Индексы таблицы `terrain`
--
ALTER TABLE `terrain`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKyn1euqr3duoveybc78so8loi` (`type_id`);

--
-- Индексы таблицы `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FKfe4xkhgeykvrf75jq4i5nv7vl` (`user_id`);

--
-- Индексы таблицы `zoo`
--
ALTER TABLE `zoo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsosb1ymtt4uaa4dboxvch3x5g` (`aviary_id`),
  ADD KEY `FKjhym3haamx42y1962up4lkibp` (`food_id`),
  ADD KEY `FKh5dj1u3quum563c5e9cdrk73i` (`kind_id`),
  ADD KEY `FK2jl31taq39wdkppmebqno437d` (`terrain_id`),
  ADD KEY `FKgyhdia1a77895iji0sa0als60` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `aviary`
--
ALTER TABLE `aviary`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `clas`
--
ALTER TABLE `clas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `employee`
--
ALTER TABLE `employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `kind`
--
ALTER TABLE `kind`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `post`
--
ALTER TABLE `post`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `programm`
--
ALTER TABLE `programm`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT для таблицы `zoo`
--
ALTER TABLE `zoo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKcm3b9d5fiw8s6co7lkw8c0lbs` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

--
-- Ограничения внешнего ключа таблицы `excursion`
--
ALTER TABLE `excursion`
  ADD CONSTRAINT `FKdoys10p4ua5wrup37d7fq0918` FOREIGN KEY (`programm_id`) REFERENCES `programm` (`id`);

--
-- Ограничения внешнего ключа таблицы `kind`
--
ALTER TABLE `kind`
  ADD CONSTRAINT `FKhxennnt88s33rv7b9d0xd7ktb` FOREIGN KEY (`clas_id`) REFERENCES `clas` (`id`);

--
-- Ограничения внешнего ключа таблицы `product_food`
--
ALTER TABLE `product_food`
  ADD CONSTRAINT `FKd4eh78hi57ijn1isixj714lq9` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKg7vkckaooo7vccith2syxesyv` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`);

--
-- Ограничения внешнего ключа таблицы `programm_terrain`
--
ALTER TABLE `programm_terrain`
  ADD CONSTRAINT `FK311s1v5rkn51fpxeienm71cuk` FOREIGN KEY (`terrain_id`) REFERENCES `terrain` (`id`),
  ADD CONSTRAINT `FKeqt3cgjxti6etxovg5mcfribi` FOREIGN KEY (`programm_id`) REFERENCES `programm` (`id`);

--
-- Ограничения внешнего ключа таблицы `terrain`
--
ALTER TABLE `terrain`
  ADD CONSTRAINT `FKyn1euqr3duoveybc78so8loi` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKfe4xkhgeykvrf75jq4i5nv7vl` FOREIGN KEY (`user_id`) REFERENCES `employee` (`id`);

--
-- Ограничения внешнего ключа таблицы `zoo`
--
ALTER TABLE `zoo`
  ADD CONSTRAINT `FK2jl31taq39wdkppmebqno437d` FOREIGN KEY (`terrain_id`) REFERENCES `terrain` (`id`),
  ADD CONSTRAINT `FKgyhdia1a77895iji0sa0als60` FOREIGN KEY (`user_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKh5dj1u3quum563c5e9cdrk73i` FOREIGN KEY (`kind_id`) REFERENCES `kind` (`id`),
  ADD CONSTRAINT `FKjhym3haamx42y1962up4lkibp` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`),
  ADD CONSTRAINT `FKsosb1ymtt4uaa4dboxvch3x5g` FOREIGN KEY (`aviary_id`) REFERENCES `aviary` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
