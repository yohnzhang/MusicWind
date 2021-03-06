package com.gildemodule.utils;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.target.ViewTarget;
import com.gildemodule.R;


/**
 * Created by yangchaojiang on 2016/8/14.
 * GlideModule 图片加载缓自定义配置
 */
public class MyGlideModule implements GlideModule {
    public static int cacheSize100MegaBytes = 504857600;

    @Override
    public void applyOptions(final Context context, GlideBuilder builder) {
        ViewTarget.setTagId(R.id.glide_tag_id);
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        // 磁盘高速缓存的大小:
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}

