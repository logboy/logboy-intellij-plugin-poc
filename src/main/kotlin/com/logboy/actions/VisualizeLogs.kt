package com.logboy.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.logboy.gui.LogboyProjectSettingsService

class VisualizeLogs : AnAction() {
  override fun actionPerformed(e: AnActionEvent?) {
    LogboyProjectSettingsService.logLocation
  }
}
