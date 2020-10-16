
package com.company.progressbarexample.ui;

import java.util.TimerTask;

import com.vaadin.flow.function.SerializableConsumer;


public class DemoTask extends TimerTask
{
	private SerializableConsumer<Integer> onProgress = null;
	private Integer                       progressIndicator;
	
	public DemoTask()
	{
		super();
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i <= 20; i++)
		{
			try
			{
				this.progressIndicator = i;
				Thread.sleep(200);
				this.onProgress.accept(this.progressIndicator);
			}
			catch(final InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public Integer onProgress(final SerializableConsumer<Integer> onProgress)
	{
		this.onProgress = onProgress;
		return this.progressIndicator;
	}
	
}
