package com.ssafy.project.wishlist.model.service;

import java.util.List;

import com.ssafy.project.wishlist.model.WishlistDto;
import com.ssafy.project.wishlist.model.WishlistImageDto;

public interface WishlistService {
	WishlistDto makeWishlist(WishlistDto wishlistDto) throws Exception;
	List<WishlistDto> showWishlist() throws Exception;
	void addWishlist(WishlistDto wishlistDto) throws Exception;
	void removeWishlist(int id) throws Exception;
}
