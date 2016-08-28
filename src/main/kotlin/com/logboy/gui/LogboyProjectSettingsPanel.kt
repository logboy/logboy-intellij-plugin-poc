package com.logboy.gui

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.ui.TextComponentAccessor
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.DocumentAdapter
import javax.swing.JPanel
import javax.swing.event.DocumentEvent

class LogboyProjectSettingsPanel() : JPanel() {
  private lateinit var logLocation: TextFieldWithBrowseButton

  @Suppress("unused")
  private lateinit var root: JPanel

  init {
    logLocation.addBrowseFolderListener(
        "", "Log location", null,

        FileChooserDescriptorFactory.createSingleFileOrFolderDescriptor(),
        TextComponentAccessor.TEXT_FIELD_WHOLE_TEXT,
        false
        )


    val textField = logLocation.textField
    logLocation.textField?.document?.addDocumentListener(object : DocumentAdapter() {
      override fun textChanged(e: DocumentEvent?) {
        try {
          LogboyProjectSettingsService.logLocation = textField.text
        } catch (e: Exception) {
          throw ConfigurationException(e.message)
        }
      }
    })
  }
}