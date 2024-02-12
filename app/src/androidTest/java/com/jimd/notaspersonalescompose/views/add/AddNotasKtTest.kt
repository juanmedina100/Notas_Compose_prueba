package com.jimd.notaspersonalescompose.views.add

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import com.jimd.notaspersonalescompose.data.EtiquetasEntity
import org.junit.Rule
import org.junit.Test
import java.util.Date


class AddNotasKtTest{
    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun testVeridyetiquetasRowAddIsVisible(){
        composeTestRule.setContent {
            etiquetasRowAdd(etiquetasEntity = EtiquetasEntity(0,"PROGRAMACION", Date()), onClicked = {})
        }
        composeTestRule.onNodeWithTag("card_etiquetaRowAdd_text",useUnmergedTree = true).assertExists()
        composeTestRule.onNodeWithTag("card_etiquetaRowAdd").performClick()

    }
}