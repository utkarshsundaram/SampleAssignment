package com.example.SampleAppDemo.ui.charts

import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import com.example.SampleAppDemo.data.model.Emotion
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

@Composable
fun PieChartView(emotions: List<Emotion>, modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            PieChart(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                description.isEnabled = false
                isDrawHoleEnabled = false
                setUsePercentValues(false)
                legend.isEnabled = true
                setBackgroundColor(Color.White.toArgb())
            }
        },
        update = { pieChart ->
            val entries = emotions.map { emotion ->
                PieEntry(emotion.value, emotion.name)
            }
            pieChart.getDescription().setEnabled(false)
            val dataSet = PieDataSet(entries, "Emotions")
            val dataSetColors = mutableListOf<Int>()
            emotions.forEach {
                dataSetColors.add(ColorTemplate.rgb(it.color))
            }
            dataSet.colors = dataSetColors
            val data = PieData(dataSet)
            data.setValueTextSize(14f)
            pieChart.data = data
            pieChart.invalidate() // Refresh the chart
        },
        modifier = modifier
    )
}
