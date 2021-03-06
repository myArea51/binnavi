/*
Copyright 2011-2016 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.binnavi.Gui.MainWindow.ProjectTree.Actions;

import com.google.security.zynamics.binnavi.Gui.Debug.BreakpointTable.Implementations.CBreakpointRemoveFunctions;
import com.google.security.zynamics.binnavi.debug.debugger.interfaces.IDebugger;
import com.google.security.zynamics.binnavi.disassembly.INaviFunction;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.types.lists.IFilledList;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;



/**
 * Action class used for removing breakpoints from functions.
 */
public final class CRemoveFunctionBreakpointsAction extends AbstractAction {
  /**
   * Used for serialization.
   */
  private static final long serialVersionUID = 4434845559962746580L;

  /**
   * List of debugger/function pairs of the breakpoints to remove.
   */
  private final IFilledList<Pair<IDebugger, INaviFunction>> m_pairs;

  /**
   * Creates a new action object.
   * 
   * @param pairs List of debugger/function pairs of the breakpoints to remove.
   */
  public CRemoveFunctionBreakpointsAction(final IFilledList<Pair<IDebugger, INaviFunction>> pairs) {
    super(pairs.size() == 1 ? String.format("Remove breakpoint from function '%s'", pairs.get(0)
        .second().getName()) : "Remove breakpoints from all selected functions");

    m_pairs = pairs;
  }

  @Override
  public void actionPerformed(final ActionEvent event) {
    CBreakpointRemoveFunctions.removeBreakpoints(m_pairs);
  }
}
