package com.kuro9.mahjongspring.discord.graphic

import java.awt.BasicStroke
import java.awt.Color
import java.awt.geom.Line2D
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

val SCORE_GRAPH_X = intArrayOf(37, 119, 202, 284, 367, 449, 532, 614, 697, 779)
val SCORE_GRAPH_Y = intArrayOf(195, 149, 102, 56)

const val SCORE_GRAPH_WIDTH = 831
const val SCORE_GRAPH_HEIGHT = 831

/**
 * 점수 그래프 이미지 생성
 * @param recentData 순위 데이터 -> 1..4로 구성된 max 10 길이의 리스트
 * @param nyanGlassIndex 냥글라스 여부 데이터 -> 냥글라스에 해당하는 [recentData]의 index
 * @return 생성된 이미지의 절대경로
 */
fun getScoreGraph(recentData: List<Int>, nyanGlassIndex: List<Int>): String {
    require(recentData.size in 0..10)
    require(recentData.all { it in 1..4 })
    require(nyanGlassIndex.all { it in recentData.indices })

    val image = BufferedImage(SCORE_GRAPH_WIDTH, SCORE_GRAPH_HEIGHT, BufferedImage.TYPE_INT_RGB)
    val graphic = image.createGraphics()
    val nyanGlassImage = ImageIO.read(File("TODO"))
    val backgroundImage = ImageIO.read(File("TODO"))

    graphic.apply {
        // 배경
        drawImage(backgroundImage, 0, 0, null)
        color = Color(0xD6, 0x5F, 0x2A) // d65f2a
        stroke = BasicStroke(6F, BasicStroke.CAP_BUTT, 0)

        // 선
        for (i in recentData.indices - 1) {
            draw(
                Line2D.Double(
                    (SCORE_GRAPH_X[i] + 26).toDouble(), SCORE_GRAPH_Y[4 - recentData[i]].toDouble(),
                    (SCORE_GRAPH_X[i + 1] + 26).toDouble(), SCORE_GRAPH_Y[4 - recentData[i + 1]].toDouble()
                )
            )
        }

        // 점
        color = Color(0xFF, 0xC0, 0x29)
        for (i in recentData.indices) {
            fillOval(SCORE_GRAPH_X[i] + 18, SCORE_GRAPH_Y[4 - recentData[i]] - 7, 15, 15)
        }

        // 냥글라스
        nyanGlassIndex.forEach {
            drawImage(
                nyanGlassImage,
                SCORE_GRAPH_X[it] - 14,
                SCORE_GRAPH_Y[4 - recentData[it]] - 30,
                null
            )
        }
    }

    val outputFile = File("todo")
    ImageIO.write(image, "png", outputFile)

    return outputFile.absolutePath
}