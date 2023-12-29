-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3306
-- 產生時間： 2023-12-29 03:15:56
-- 伺服器版本： 5.7.24
-- PHP 版本： 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫: `projectdb`
--

-- --------------------------------------------------------

--
-- 資料表結構 `activitydetails`
--

CREATE TABLE `activitydetails` (
  `ProductsID` varchar(255) NOT NULL,
  `ActivitysID` int(11) NOT NULL,
  `Discount` double(3,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `activitydetails`
--

INSERT INTO `activitydetails` (`ProductsID`, `ActivitysID`, `Discount`) VALUES
('TW_tt_B_0001', 1, 0.80);

-- --------------------------------------------------------

--
-- 資料表結構 `activitys`
--

CREATE TABLE `activitys` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `StartDate` datetime NOT NULL,
  `EndDate` datetime NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Method` varchar(255) NOT NULL,
  `FreeShipping` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `activitys`
--

INSERT INTO `activitys` (`ID`, `Name`, `StartDate`, `EndDate`, `Description`, `Method`, `FreeShipping`) VALUES
(1, '新店開幕/折扣大放送', '2023-12-27 00:00:00', '2023-12-31 00:00:00', NULL, '商品折扣', NULL),
(2, '新店開幕/滿千免運', '2023-12-27 00:00:00', '2023-12-31 00:00:00', NULL, '免運活動', 1000),
(3, '迎接新年/全店8折', '2023-12-27 00:00:00', '2023-12-31 00:00:00', NULL, '商品折扣', NULL);

-- --------------------------------------------------------

--
-- 資料表結構 `members`
--

CREATE TABLE `members` (
  `ID` varchar(255) NOT NULL,
  `Mail` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Phone` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `members`
--

INSERT INTO `members` (`ID`, `Mail`, `Password`, `Name`, `Phone`, `City`, `Address`, `Count`) VALUES
('21568767', 'amy@gmail.com', '12345', 'Amy0258', '0988999888', '桃園市', '青埔區青埔路', 0),
('25896314', 'Brad@gmail.com', '12345', 'Brad_chao', '0978111222', '台中市', '南屯區公益路二段205號', 0);

-- --------------------------------------------------------

--
-- 資料表結構 `orderdetails`
--

CREATE TABLE `orderdetails` (
  `OrdersID` varchar(255) NOT NULL,
  `ProductsID` varchar(255) NOT NULL,
  `Amount` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `orderdetails`
--

INSERT INTO `orderdetails` (`OrdersID`, `ProductsID`, `Amount`, `Price`, `Quantity`) VALUES
('TT2023121300001', 'TW_tt_B_0001', 990, 99, 10);

-- --------------------------------------------------------

--
-- 資料表結構 `orders`
--

CREATE TABLE `orders` (
  `ID` varchar(255) NOT NULL,
  `MembersID` varchar(255) NOT NULL,
  `ProductsID` varchar(255) NOT NULL,
  `OrderState` varchar(255) NOT NULL,
  `EcPayReturn` varchar(2550) NOT NULL,
  `PaymentMethod` varchar(255) NOT NULL,
  `PaymentState` varchar(255) NOT NULL,
  `Amount` int(11) NOT NULL,
  `ShipMethod` varchar(255) NOT NULL,
  `ShipState` varchar(255) NOT NULL,
  `ShipDate` datetime NOT NULL,
  `ReceiverName` varchar(255) NOT NULL,
  `ReceiverPhone` varchar(255) NOT NULL,
  `ReceiverMail` varchar(255) NOT NULL,
  `ReceiverCity` varchar(255) NOT NULL,
  `ReceiverAddress` varchar(255) NOT NULL,
  `BuyerName` varchar(255) NOT NULL,
  `BuyerPhone` varchar(255) NOT NULL,
  `BuyerMail` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `orders`
--

INSERT INTO `orders` (`ID`, `MembersID`, `ProductsID`, `OrderState`, `EcPayReturn`, `PaymentMethod`, `PaymentState`, `Amount`, `ShipMethod`, `ShipState`, `ShipDate`, `ReceiverName`, `ReceiverPhone`, `ReceiverMail`, `ReceiverCity`, `ReceiverAddress`, `BuyerName`, `BuyerPhone`, `BuyerMail`) VALUES
('TT2023121300001', '25896314', 'TW_tt_B_0001', '尚未處理', 'EcPayReturn', '信用卡付款', '已付款', 1680, '賣家宅配', '尚未出貨', '2023-12-27 00:00:00', 'Brad_chao', '0978111222', 'Brad@gmail.com', '台中市', '公益路二段', 'Brad_chao', '0978111222', 'Brad@gmail.com');

-- --------------------------------------------------------

--
-- 資料表結構 `products`
--

CREATE TABLE `products` (
  `ID` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `ActivitysID` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Cost` int(11) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Shelves` int(11) NOT NULL,
  `Stock` int(11) DEFAULT NULL,
  `Discontinued` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `products`
--

INSERT INTO `products` (`ID`, `Name`, `ActivitysID`, `Price`, `Cost`, `Description`, `Shelves`, `Stock`, `Discontinued`) VALUES
('TW_tt_B_0001', '荔枝紅茶', 1, 9999, NULL, NULL, 1000, NULL, 0),
('TW_tt_G_0001', '八爪綠茶', 2, 9999, 1000, '好喝的綠茶', 1000, 1000, 0);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `activitydetails`
--
ALTER TABLE `activitydetails`
  ADD PRIMARY KEY (`ProductsID`,`ActivitysID`),
  ADD KEY `ActivitysID` (`ActivitysID`),
  ADD KEY `ProductsID` (`ProductsID`);

--
-- 資料表索引 `activitys`
--
ALTER TABLE `activitys`
  ADD PRIMARY KEY (`ID`);

--
-- 資料表索引 `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`ID`);

--
-- 資料表索引 `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`OrdersID`,`ProductsID`),
  ADD KEY `ProductsID` (`ProductsID`),
  ADD KEY `OrdersID` (`OrdersID`);

--
-- 資料表索引 `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `MembersID` (`MembersID`),
  ADD KEY `ProductsID` (`ProductsID`);

--
-- 資料表索引 `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ActivitysID` (`ActivitysID`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `activitys`
--
ALTER TABLE `activitys`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `activitydetails`
--
ALTER TABLE `activitydetails`
  ADD CONSTRAINT `activitydetails_ibfk_1` FOREIGN KEY (`ProductsID`) REFERENCES `products` (`ID`),
  ADD CONSTRAINT `activitydetails_ibfk_2` FOREIGN KEY (`ActivitysID`) REFERENCES `activitys` (`ID`);

--
-- 資料表的限制式 `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`OrdersID`) REFERENCES `orders` (`ID`),
  ADD CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`ProductsID`) REFERENCES `products` (`ID`);

--
-- 資料表的限制式 `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`MembersID`) REFERENCES `members` (`ID`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`ProductsID`) REFERENCES `products` (`ID`);

--
-- 資料表的限制式 `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`ActivitysID`) REFERENCES `activitys` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
