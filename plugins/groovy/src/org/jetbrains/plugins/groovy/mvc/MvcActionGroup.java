/*
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jetbrains.plugins.groovy.mvc;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.Pair;

public class MvcActionGroup extends DefaultActionGroup implements DumbAware {

  @Override
  public void update(AnActionEvent e) {
    Presentation presentation = e.getPresentation();

    Pair<MvcFramework, Module> pair = MvcActionBase.guessFramework(e);

    if (pair != null && pair.first.showActionGroup()) {
      presentation.setVisible(true);
      presentation.setText(pair.getFirst().getDisplayName());
      presentation.setIcon(pair.getFirst().getIcon());
    }
    else {
      presentation.setVisible(false);
    }
  }
}
