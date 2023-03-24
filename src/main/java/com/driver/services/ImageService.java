package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setDimensions(dimensions);
        image.setDescription(description);
        Blog blog = blogRepository2.findById(blogId).get();
        image.setBlog(blog);

        List<Image> images = blog.getImages();
        images.add(image);
        blog.setImages(images);
        blogRepository2.save(blog);
        return image;


    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image= imageRepository2.findById(id).get();
        String imageDimensions = image.getDimensions();
        String screenDimension[]=screenDimensions.split("X");
        String imageDimension []= imageDimensions.split("X");
        int l_screen = Integer.parseInt(screenDimension[0]);
        int b_screen = Integer.parseInt(screenDimension[1]);

        int l_image = Integer.parseInt(imageDimension[0]);
        int b_image = Integer.parseInt(imageDimension[0]);

        int length = l_screen/l_image;
        int breadth = b_screen/b_image;
        return length*breadth;


    }
}
