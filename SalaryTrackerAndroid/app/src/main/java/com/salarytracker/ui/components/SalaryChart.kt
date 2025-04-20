package com.salarytracker.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.salarytracker.data.model.SalaryData
import com.salarytracker.ui.theme.Typography
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.graphics.Color
import com.github.mikephil.charting.utils.ColorTemplate

@Composable
fun SalaryChart(
    salaryData: List<SalaryData>,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            BarChart(context).apply {
                description.isEnabled = false
                setDrawGridBackground(false)
                setDrawBarShadow(false)
                setDrawValueAboveBar(true)
                isHighlightFullBarEnabled = false
                setDrawBorders(false)
                animateY(1000)
            }
        },
        modifier = modifier,
        update = { chart ->
            val entries = salaryData.mapIndexed { index, salary ->
                BarEntry(index.toFloat(), salary.monthlyGrossSalary.toFloat())
            }
            
            val dataSet = BarDataSet(entries, "Salary Distribution").apply {
                colors = ColorTemplate.MATERIAL_COLORS.toList()
                valueTextSize = 12f
                valueTextColor = Color.Black.hashCode()
            }
            
            chart.data = BarData(dataSet)
            chart.invalidate()
        }
    )
} 