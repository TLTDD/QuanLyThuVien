-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 10, 2021 lúc 05:02 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thuvienute`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `kesach`
--

CREATE TABLE `kesach` (
  `id` int(11) NOT NULL,
  `tenKeSach` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `kesach`
--

INSERT INTO `kesach` (`id`, `tenKeSach`) VALUES
(1, 'Kệ sách A'),
(2, 'Kệ sách B'),
(3, 'Kệ sách C');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `id` int(11) NOT NULL,
  `idKeSach` int(11) NOT NULL,
  `tenSach` varchar(255) NOT NULL,
  `tenTacGia` varchar(255) NOT NULL,
  `nhaXuatBan` varchar(255) NOT NULL,
  `ngayXuatBan` varchar(255) NOT NULL,
  `ngonNgu` varchar(255) NOT NULL,
  `giaSach` int(11) NOT NULL,
  `soSeries` varchar(255) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `loiTua` varchar(1000) NOT NULL,
  `hinhAnhSach` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`id`, `idKeSach`, `tenSach`, `tenTacGia`, `nhaXuatBan`, `ngayXuatBan`, `ngonNgu`, `giaSach`, `soSeries`, `soLuong`, `loiTua`, `hinhAnhSach`) VALUES
(1, 1, 'Cây Cam Ngọt Của Tôi', 'Jose Mauro de Vasconcelos', 'Nhà Xuất Bản Hội Nhà Văn', '12/12/2012', 'Tiếng việt', 365000, '1245-1412-1452-3251', 7, 'Cây Cam Ngọt Của Tôi là tác phẩm của nhà văn người Brazil Jose Mauro de Vasconcelos. Sinh ra và lớn lên trong một gia đình nghèo ở ngoại ô Rio de Janeiro, ông phải làm đủ nghề để trang trải cho cuộc sống. \n\nKhông ban cho Mauro một gia đình giàu có nhưng trời phú cho vị tác giả này một trí nhớ phi thường, trí tưởng tượng tuyệt vời và vốn sống vô cùng phong phú. Mauro bắt đầu sáng tác từ năm 22 tuổi. Cuốn sách Cây Cam Ngọt Của Tôi của ông không chỉ thành công tại Brazil (được đưa vào chương trình tiểu học của nước này) mà còn được bán bản quyền cho hơn 20 quốc gia và chuyển thể thành phim.', 'https://lh3.googleusercontent.com/proxy/-YlXjV6a5_JSPvtVVm4clHP0KHKSd6oAhuuwinOYaUatVCs57ySrBjPLb_dwZ581HNdAJ3CLp2WnaVeHN2Vr5q_wPLQ1GU1I-4yQmml8MtptnmVy4EGy4-W0DkZw37JfT_R8-lyf');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `kesach`
--
ALTER TABLE `kesach`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `kesach`
--
ALTER TABLE `kesach`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
