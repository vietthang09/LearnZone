package com.vku.learnzone.utils

import com.vku.learnzone.model.Course
import com.vku.learnzone.model.Video

object Data {
    val categoryList: List<String> = listOf(
        "https://cdn4.iconfinder.com/data/icons/presentation-color/100/Communication_Skill-512.png",
        "https://freeiconshop.com/wp-content/uploads/edd/android-flat.png",
        "https://i.pinimg.com/originals/44/f0/0d/44f00d6dc54c73e29bcc362c1bd5cd8a.png",
        "https://icons-for-free.com/download-icon-brush+design+draw+drawing+icon-1320168140159902387_512.png",
        "https://cdn.iconscout.com/icon/free/png-256/hacker-15-448496.png",
        "https://cdn-icons-png.flaticon.com/512/2534/2534390.png",
    )

    val courseList: List<Course> = listOf(
        Course(
            1,
            "3D Design Basic",
            "https://i.pinimg.com/originals/1c/d3/93/1cd3938d1aeafc32b21dc7e5566ef2be.png",
            "24.99",
            "In this course, you will learn how to build a space to a 3 dimensional production. There are 24 premium learning videos for you.",
            "aa",
            "aa"
        ),
        Course(
            2,
            "Deep Learning",
            "https://codelearn.io/Upload/Blog/lam-duoc-gi-sau-1-nam-hoc-deep-learning-63745502001.7321.jpg",
            "45.11",
            "In this course, you will learn how to build a space to a 3 dimensional production. There are 24 premium learning videos for you.",
            "aa",
            "aa"
        ),
        Course(
            3,
            "Photoshop",
            "https://justcreative.com/wp-content/uploads/2022/03/Photoshop-Tutorials-The-Ultimate-Guide.png",
            "20.23",
            "In this course, you will learn how to build a space to a 3 dimensional production. There are 24 premium learning videos for you.",
            "aa",
            "aa"
        ),
    )

    val videoList: List<Video> = listOf(
        Video(
            "https://i.pinimg.com/originals/1c/d3/93/1cd3938d1aeafc32b21dc7e5566ef2be.png",
            "Introduction to 3D",
            "20"
        ),
        Video(
            "http://verladams.com/gallery/teaching/pre-architecture/rectilinear_volumes/sam_lassiter.jpg",
            "3D Fundamentals",
            "22"
        ),
        Video(
            "https://i.ytimg.com/vi/kMi_0HXXaTE/maxresdefault.jpg",
            "Introduction App",
            "20"
        ),
    )
}

