package com.yoghurt.crypto.transactions.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.yoghurt.crypto.transactions.client.i18n.M;
import com.yoghurt.crypto.transactions.client.util.script.ExecutionStep;

public class ScriptStateViewer extends Composite {
  interface ScriptStateViewerImplUiBinder extends UiBinder<Widget, ScriptStateViewer> {}

  private static final ScriptStateViewerImplUiBinder UI_BINDER = GWT.create(ScriptStateViewerImplUiBinder.class);

  @UiField HeadingWidget scriptStepTitle;
  @UiField ScriptExecutionViewer operationViewer;
  @UiField Label description;
  @UiField ScriptExecutionViewer scriptExecutionViewer;
  @UiField StackViewer stackViewer;
  @UiField Label executionError;

  public ScriptStateViewer(final ExecutionStep state, final int idx) {
    initWidget(UI_BINDER.createAndBindUi(this));

    scriptStepTitle.setText(M.messages().scriptExecutionStep(idx));

    operationViewer.clear();
    operationViewer.addField(state.getInstruction());

    description.setText(M.messages().scriptOperationDescription(state.getInstruction().getOperation()));

    scriptExecutionViewer.setScript(state.getScript());

    stackViewer.setStack(state.getStack());

    executionError.setVisible(state.hasExecutionError());
  }
}
