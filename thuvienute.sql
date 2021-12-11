-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 11, 2021 lúc 01:46 AM
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
(1, 1, 'Cây Cam Ngọt Của Tôi', 'Jose Mauro de Vasconcelos', 'Nhà Xuất Bản Hội Nhà Văn', '12/12/2012', 'Tiếng việt', 365000, '1245-1412-1452-3251', 7, 'Cây Cam Ngọt Của Tôi là tác phẩm của nhà văn người Brazil Jose Mauro de Vasconcelos. Sinh ra và lớn lên trong một gia đình nghèo ở ngoại ô Rio de Janeiro, ông phải làm đủ nghề để trang trải cho cuộc sống. \n\nKhông ban cho Mauro một gia đình giàu có nhưng trời phú cho vị tác giả này một trí nhớ phi thường, trí tưởng tượng tuyệt vời và vốn sống vô cùng phong phú. Mauro bắt đầu sáng tác từ năm 22 tuổi. Cuốn sách Cây Cam Ngọt Của Tôi của ông không chỉ thành công tại Brazil (được đưa vào chương trình tiểu học của nước này) mà còn được bán bản quyền cho hơn 20 quốc gia và chuyển thể thành phim.', 'https://lh3.googleusercontent.com/proxy/-YlXjV6a5_JSPvtVVm4clHP0KHKSd6oAhuuwinOYaUatVCs57ySrBjPLb_dwZ581HNdAJ3CLp2WnaVeHN2Vr5q_wPLQ1GU1I-4yQmml8MtptnmVy4EGy4-W0DkZw37JfT_R8-lyf'),
(2, 2, 'Ngữ Pháp Tiếng Hàn Cơ Bản', ' Lê Huy Khoa', 'Nhà xuất bản Kim Đồng', '15/02/2008', 'Tiếng Pháp', 458000, '2547-1456-1254-1475', 9, 'NGỮ PHÁP CƠ BẢN TIẾNG HÀN của tác giả Lê Huy Khoa, hệ thống một cách đầy đủ, chính xác và khoa học nhất các kiến thức cơ bản về ngữ pháp tiếng Hàn như danh từ, động từ, tính từ…', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-ngu-phap-tieng-han-co-ban.jpg'),
(3, 3, 'Đổi Đen Thay Trắng', 'Phong Lưu Thư Ngốc', 'Nhà xuất bản Hoài Nam', '14/01/2021', 'Tiếng Việt', 456000, '1455-1441-4125-2541', 5, 'Một hack cơ khi bị Chủ Thần nhìn trúng thì sẽ chỉ làm nhân vật phản diện suốt mấy nghìn năm, kiếp nào cũng sẽ tìm đến con đường chết, rơi vào kết cục bi thảm.\r\nRốt cuộc một ngày kia cũng thoát khỏi sự khống chế của hệ thống phản diện, hắn quyết định điều tra ngược lại để báo thù, nhằm thay đổi vận mệnh. \r\nDù nội tâm có rữa nát như thế nào đi chăng nữa thì ngoài mặt, hắn vẫn phải luôn đứng trên chuẩn mực đạo đức cao nhất.', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-cao-thu-doi-den-thay-trang.jpg'),
(4, 2, 'Kanji Look', 'Nguyễn Việt Anh', 'NXB Từ Điển Bách Khoa', '14/02/2019', 'Tiếng Nhật', 254000, '1475-2547-1456-1425', 5, 'Kanji look and learn N3, N2 – Bản Nhật Việt được biên soạn bắt nguồn từ quyển sách Kanji Pixtographic – là cuốn sách dạy Kanji ở trình độ trung cấp N3 và N2 bằng hình ảnh cực hay. Tuy nhiên điểm hạn chế của nó là trình bày không được khoa học như cuốn Kanji look and learn và hoàn toàn bằng tiếng Anh. Vậy nên, tác giả đã ghép lại các hình ảnh từ cuốn sách này và phối hợp ghép các hình ảnh có sẵn của quyển Kanji look and learn để tạo nên một quyển sách mới, hoàn toàn tiếng Việt với cách trình bày khoa học và vô cùng dễ học với cái tên là Kanji look and learn N23 phiên bản tiếng Việt', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-kanji-look-and-learn-n3-n2-ban-nhat-viet.jpg'),
(5, 1, 'Cát Bụi Chân Ai', 'Tô Hoài', 'Nhà xuất bản Kim Đồng', '12/05/2019', 'Tiếng Việt', 125000, '254-145-145-254', 20, 'Mở đầu bằng mối giao tình giữa Tô Hoài và Nguyễn Tuân. Kết thúc bằng cái chết của Nguyễn Tuân. Giữa hai nhà văn đó là những kiếp nhân sinh chập chờn như những bóng ma trơi. Giữa hai nhà văn đó là không khí ngột ngạt của văn nghệ, kháng chiến, cách mạng và chính trị. Giữa hai nhà văn đó, cho tới khi có một người nằm xuống, đã một nửa thế kỷ trôi qua…(Hoàng Khởi Phong)', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-cat-bui-chan-ai.jpg');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
