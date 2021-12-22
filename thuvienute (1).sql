-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 22, 2021 lúc 05:16 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.1.0

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
-- Cấu trúc bảng cho bảng `bandoc`
--

CREATE TABLE `bandoc` (
  `id` int(11) NOT NULL,
  `hoTen` varchar(255) NOT NULL,
  `maSV` varchar(255) NOT NULL,
  `lop` varchar(255) NOT NULL,
  `ngaySinh` varchar(255) NOT NULL,
  `gioiTinh` varchar(255) NOT NULL,
  `diaChi` varchar(255) NOT NULL,
  `soDienThoai` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `bandoc`
--

INSERT INTO `bandoc` (`id`, `hoTen`, `maSV`, `lop`, `ngaySinh`, `gioiTinh`, `diaChi`, `soDienThoai`, `email`) VALUES
(1, 'Nguyễn Quang Huy', '1911505310224', '19T2', '12/12/1999', 'Nam', 'Kon Tum', '0961640909', 'huylmht10@gmail.com'),
(2, 'Bùi Văn Sỷ', '1911505310248', '19T2', '10/6/2001', 'Nam', 'Quản Trị', '\r\n0947895039', '\r\nsybuivan1429@gmail.com'),
(9, 'Phạm Văn Thiên', '1911505410245', '19T2', '12/4/2001', 'Nam', 'Quãng Nam', '09616450906', 'pvthien@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietmuon`
--

CREATE TABLE `chitietmuon` (
  `id` int(11) NOT NULL,
  `maPM` int(11) NOT NULL,
  `tenSach` varchar(255) NOT NULL,
  `maSach` varchar(255) NOT NULL,
  `ngayMuon` varchar(255) NOT NULL,
  `ngayHetHan` varchar(255) NOT NULL,
  `trangThai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietmuon`
--

INSERT INTO `chitietmuon` (`id`, `maPM`, `tenSach`, `maSach`, `ngayMuon`, `ngayHetHan`, `trangThai`) VALUES
(1, 1, 'Đổi Đen Thay Trắng', '3', '12/12/2021', '11/01/2021', 'Đang mượn'),
(3, 2, 'Hồ Nữ', '6', '16/12/2021', '1/1/2022', 'Đang mượn'),
(6, 2, 'Cát Bụi Chân Ai', '5', '9/11/2021', '31/11/2021', 'Đang mượn');

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
  `tenKeSach` varchar(255) NOT NULL,
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

INSERT INTO `sach` (`id`, `tenKeSach`, `tenSach`, `tenTacGia`, `nhaXuatBan`, `ngayXuatBan`, `ngonNgu`, `giaSach`, `soSeries`, `soLuong`, `loiTua`, `hinhAnhSach`) VALUES
(1, 'Kệ sách A', 'Cây Cam Ngọt Của Tôi', 'Jose Mauro de Vasconcelos', 'Nhà Xuất Bản Hội Nhà Văn', '12/12/2012', 'Tiếng việt', 365000, '1245-1412-1452-3251', 7, 'Cây Cam Ngọt Của Tôi là tác phẩm của nhà văn người Brazil Jose Mauro de Vasconcelos. Sinh ra và lớn lên trong một gia đình nghèo ở ngoại ô Rio de Janeiro, ông phải làm đủ nghề để trang trải cho cuộc sống. \n\nKhông ban cho Mauro một gia đình giàu có nhưng trời phú cho vị tác giả này một trí nhớ phi thường, trí tưởng tượng tuyệt vời và vốn sống vô cùng phong phú. Mauro bắt đầu sáng tác từ năm 22 tuổi. Cuốn sách Cây Cam Ngọt Của Tôi của ông không chỉ thành công tại Brazil (được đưa vào chương trình tiểu học của nước này) mà còn được bán bản quyền cho hơn 20 quốc gia và chuyển thể thành phim.', 'https://thegioidohoa.com/wp-content/uploads/2017/08/Top-m%E1%BA%ABu-thi%E1%BA%BFt-k%E1%BA%BF-b%C3%ACa-s%C3%A1ch-%C4%91%E1%BA%B9p-l%C3%B4i-cu%E1%BB%91n.jpg'),
(2, 'Kệ sách B', 'Ngữ Pháp Tiếng Hàn Cơ Bản', ' Lê Huy Khoa', 'Nhà xuất bản Kim Đồng', '15/02/2008', 'Tiếng Pháp', 458000, '2547-1456-1254-1475', 9, 'NGỮ PHÁP CƠ BẢN TIẾNG HÀN của tác giả Lê Huy Khoa, hệ thống một cách đầy đủ, chính xác và khoa học nhất các kiến thức cơ bản về ngữ pháp tiếng Hàn như danh từ, động từ, tính từ…', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-ngu-phap-tieng-han-co-ban.jpg'),
(3, 'Kệ sách A', 'Đổi Đen Thay Trắng', 'Phong Lưu Thư Ngốc', 'Nhà xuất bản Hoài Nam', '14/01/2021', 'Tiếng Việt', 456000, '1455-1441-4125-2541', 5, 'Một hack cơ khi bị Chủ Thần nhìn trúng thì sẽ chỉ làm nhân vật phản diện suốt mấy nghìn năm, kiếp nào cũng sẽ tìm đến con đường chết, rơi vào kết cục bi thảm.\r\nRốt cuộc một ngày kia cũng thoát khỏi sự khống chế của hệ thống phản diện, hắn quyết định điều tra ngược lại để báo thù, nhằm thay đổi vận mệnh. \r\nDù nội tâm có rữa nát như thế nào đi chăng nữa thì ngoài mặt, hắn vẫn phải luôn đứng trên chuẩn mực đạo đức cao nhất.', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-cao-thu-doi-den-thay-trang.jpg'),
(4, 'Kệ sách B', 'Kanji Look', 'Nguyễn Việt Anh', 'NXB Từ Điển Bách Khoa', '14/02/2019', 'Tiếng Nhật', 254000, '1475-2547-1456-1425', 5, 'Kanji look and learn N3, N2 – Bản Nhật Việt được biên soạn bắt nguồn từ quyển sách Kanji Pixtographic – là cuốn sách dạy Kanji ở trình độ trung cấp N3 và N2 bằng hình ảnh cực hay. Tuy nhiên điểm hạn chế của nó là trình bày không được khoa học như cuốn Kanji look and learn và hoàn toàn bằng tiếng Anh. Vậy nên, tác giả đã ghép lại các hình ảnh từ cuốn sách này và phối hợp ghép các hình ảnh có sẵn của quyển Kanji look and learn để tạo nên một quyển sách mới, hoàn toàn tiếng Việt với cách trình bày khoa học và vô cùng dễ học với cái tên là Kanji look and learn N23 phiên bản tiếng Việt', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-kanji-look-and-learn-n3-n2-ban-nhat-viet.jpg'),
(5, 'Kệ sách A', 'Cát Bụi Chân Ai', 'Tô Hoài', 'Nhà xuất bản Kim Đồng', '12/05/2019', 'Tiếng Việt', 125000, '254-145-145-254', 20, 'Mở đầu bằng mối giao tình giữa Tô Hoài và Nguyễn Tuân. Kết thúc bằng cái chết của Nguyễn Tuân. Giữa hai nhà văn đó là những kiếp nhân sinh chập chờn như những bóng ma trơi. Giữa hai nhà văn đó là không khí ngột ngạt của văn nghệ, kháng chiến, cách mạng và chính trị. Giữa hai nhà văn đó, cho tới khi có một người nằm xuống, đã một nửa thế kỷ trôi qua…(Hoàng Khởi Phong)', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-cat-bui-chan-ai.jpg'),
(6, 'Kệ sách C', 'Hồ Nữ', 'Dịch Ngũ', 'NXB Kim Liên', '25/2/2021', 'Tiếng việt', 235000, '234-789-643', 8, 'Nữ chính hơn người ở điểm nào? Như vậy thì nam thần sao có thể để ngươi nhúng chàm? \r\n\r\nBiện pháp bảo vệ duy nhất chính là chiếm lấy nam thần làm của riêng.\r\n\r\nTiên quân sờ lỗ tai của tiểu hồ ly hỏi: “Tuyết Hoa, ngươi thích hồ ly đực như thế nào?”\r\n\r\nTiểu hồ ly nhìn đàm hồ ly tinh đực trước mặt nhưng đầu lại suy tính làm thế nào để đẩy ngãy tiên quân đây?', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-ho-nu.jpg'),
(7, 'Kệ sách C', 'Vũ Khí Bóng Đêm ', 'Cassandra Clare', 'NXB Kim Đồng', '12/12/2009', 'Tiếng Việt', 209000, '123746352', 65, 'Một thế giới bí ẩn sắp bị tiết lộ…\r\n\r\nKhi ghé đến CLB Pandemonium ở thành phố New York, cô gái mười lăm tuổi Clary Fray chưa bao giờ mong rằng mình sẽ chứng kiến một vụ giết người – huống hồ thủ phạm ra tay lại là ba thiếu niên có hình xăm kỳ lạ trên người và sử dụng những vũ khí dị thường. Clary biết mình nên gọi cảnh sát, nhưng làm sao để cô giải thích với họ đây khi mà cái xác đã biến mất, không để lại chút dấu vết, trong khi đó, chẳng ai ngoài Clary trông thấy ba kẻ sát nhân.\r\n\r\nTuy có bất ngờ vì bị Clary nhìn thấy, nhưng ba người nọ đã giải thích cho cô: họ là những Thợ Săn Bóng Tối, một nhóm những chiến binh bí ẩn dâng hiến đời mình để quét sạch ma quỷ khỏi trái đất. Trong vòng hai mươi bốn giờ, mẹ Clary đã mất tích và chính Clary cũng bị một con quỷ tấn công.\r\n\r\nNhưng tại sao lũ quỷ lại nảy sinh hứng thú với những người phàm như Clary và mẹ cô? Và làm thế nào cô bỗng nhìn thấy những sự vật vô hình? Các Thợ Săn Bóng Tối rất tò mò muốn biết…', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-vu-khi-bong-dem-1-thanh-pho-xuong.jpg'),
(12, 'Kệ sách B', '36 động từ bqt', 'Văn Thiên', 'NXB kim đồng', '12/3/2001', 'tiếng việt', 234400, '234-363-123', 26, 'Động từ bất quy tắc được sử dụng rất nhiều trong câu điều kiện căn bản. Đây cũng là một kiến thức vô cùng quan trọng đối với những người mới bắt đầu học tiếng Anh. Những động từ bất quy tắc ấy là gì? Chúng được sử dụng như thế nào? Nó có thực sự quan trọng trong tiếng Anh?\r\n\r\nTrong tiếng Anh có hơn 600 động từ bất quy tắc khác nhau. Nhưng trong thực tế thì số từ được sử dụng thường xuyên chỉ khoảng hơn 200 từ và các dạng của chúng cũng đa số giống nhau.\r\n\r\nSachvui.com xin giới thiệu đến các bạn ebook 360 động từ bất quy tắc đầy đủ, mong rằng sẽ giúp ích được cho các bạn trong quá trình học tập và làm việc.', 'https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-360-dong-tu-bat-quy-tac-day-du.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `taiKhoan` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `soDienThoai` varchar(50) NOT NULL,
  `diaChi` varchar(255) NOT NULL,
  `ngaySinh` varchar(100) NOT NULL,
  `maQuyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `name`, `taiKhoan`, `password`, `soDienThoai`, `diaChi`, `ngaySinh`, `maQuyen`) VALUES
(1, 'Nguyễn Quang Huy', 'nqhuy', 'nqhuy', '961640903', 'Kon Tum', '12/12/1999', 1),
(3, 'Bùi Văn Sỷ', 'bvsy', '1', '254125145', 'Quảng Trị', '12/1/2001', 2),
(4, 'Phạm Văn Thiên', '1911505310224', '1', '0961640909', 'Quãng Nam', '12/12/1999', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bandoc`
--
ALTER TABLE `bandoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `chitietmuon`
--
ALTER TABLE `chitietmuon`
  ADD PRIMARY KEY (`id`);

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
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bandoc`
--
ALTER TABLE `bandoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `chitietmuon`
--
ALTER TABLE `chitietmuon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `kesach`
--
ALTER TABLE `kesach`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
