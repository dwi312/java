package com.example.pemesanan.core;

import java.util.HashMap;
import java.util.Map;

import com.example.pemesanan.exception.ProdukTidakDitemukanException;
import com.example.pemesanan.exception.StokTidakCukupException;

public class Inventaris {
    private static Map<String, Integer> stokProduk = new HashMap<>();

    static {
        stokProduk.put("P001", 10);
        stokProduk.put("P002", 5);
        stokProduk.put("P003", 20);
    }

    public static int getStok(String produkId) {
        return stokProduk.getOrDefault(produkId, 0);
    }

    public static void kurangiStok(String produkId, int jumlah) throws StokTidakCukupException, ProdukTidakDitemukanException {
        if (!stokProduk.containsKey(produkId)) {
            throw new ProdukTidakDitemukanException("Produk dengan ID " + produkId + " tidak ditemukan.");
        }
        int stokSekarang = stokProduk.get(produkId);
        if (stokSekarang < jumlah) {
            throw new StokTidakCukupException("Stok tidak cukup untuk produk " + produkId + ". Tersedia: " + stokSekarang);
        }
        stokProduk.put(produkId, stokSekarang - jumlah);
        System.out.println("Stok produk " + produkId + " berhasil dikurangi. Stok tersisa: " + stokProduk.get(produkId));
    }

}
