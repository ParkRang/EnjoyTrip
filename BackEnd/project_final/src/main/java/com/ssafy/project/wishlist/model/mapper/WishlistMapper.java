package com.ssafy.project.wishlist.model.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.project.wishlist.model.WishlistDto;
import com.ssafy.project.wishlist.model.WishlistImageDto;

@Mapper
public interface WishlistMapper {
	WishlistDto makeWishlist(WishlistDto wishlistDto) throws Exception;
	List<WishlistDto> showWishlist() throws Exception;
	void addWishlist(WishlistDto wishlistDto) throws Exception;
	void removeWishlist(int id) throws Exception;
}
