-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Jun 2024 pada 04.40
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_detail_biaya`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `biaya`
--

CREATE TABLE `biaya` (
  `id_biaya` int(11) NOT NULL,
  `nama_biaya` varchar(255) NOT NULL,
  `nominal_biaya` varchar(255) NOT NULL,
  `id_jurusan` int(11) NOT NULL,
  `id_tapel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `biaya`
--

INSERT INTO `biaya` (`id_biaya`, `nama_biaya`, `nominal_biaya`, `id_jurusan`, `id_tapel`) VALUES
(1, 'SPP', '150000', 1, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_biaya`
--

CREATE TABLE `detail_biaya` (
  `id_detail_biaya` int(11) NOT NULL,
  `id_siswa` int(11) NOT NULL,
  `tgl_bayar` varchar(255) NOT NULL,
  `id_biaya` int(11) NOT NULL,
  `dibayar` varchar(255) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `detail_biaya`
--

INSERT INTO `detail_biaya` (`id_detail_biaya`, `id_siswa`, `tgl_bayar`, `id_biaya`, `dibayar`, `id_user`) VALUES
(1, 1, '18 agustus 2024', 1, '150000', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jurusan`
--

CREATE TABLE `jurusan` (
  `id_jurusan` int(11) NOT NULL,
  `kode_jurusan` varchar(255) NOT NULL,
  `nama_jurusan` varchar(255) NOT NULL,
  `kaprodi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `jurusan`
--

INSERT INTO `jurusan` (`id_jurusan`, `kode_jurusan`, `nama_jurusan`, `kaprodi`) VALUES
(1, '111', 'Teknik Informatika', 'Siti Nurhaliza,S.Kom');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tapel`
--

CREATE TABLE `tapel` (
  `id_tapel` int(11) NOT NULL,
  `tahun_tapel` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tapel`
--

INSERT INTO `tapel` (`id_tapel`, `tahun_tapel`) VALUES
(1, '2024');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `biaya`
--
ALTER TABLE `biaya`
  ADD PRIMARY KEY (`id_biaya`),
  ADD KEY `id_tapel` (`id_tapel`);

--
-- Indeks untuk tabel `detail_biaya`
--
ALTER TABLE `detail_biaya`
  ADD PRIMARY KEY (`id_detail_biaya`);

--
-- Indeks untuk tabel `jurusan`
--
ALTER TABLE `jurusan`
  ADD PRIMARY KEY (`id_jurusan`);

--
-- Indeks untuk tabel `tapel`
--
ALTER TABLE `tapel`
  ADD PRIMARY KEY (`id_tapel`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `biaya`
--
ALTER TABLE `biaya`
  MODIFY `id_biaya` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=334;

--
-- AUTO_INCREMENT untuk tabel `detail_biaya`
--
ALTER TABLE `detail_biaya`
  MODIFY `id_detail_biaya` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `jurusan`
--
ALTER TABLE `jurusan`
  MODIFY `id_jurusan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `tapel`
--
ALTER TABLE `tapel`
  MODIFY `id_tapel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
