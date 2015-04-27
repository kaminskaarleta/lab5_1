package edu.iis.mto.multithread;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

public class BetterRadarTest {

	 @Rule
	 public RepeatRule repeatRule = new RepeatRule();


	@Repeat( times = 10000 )
	@Test
	public void launchPatriotTenTimesWhenNoticesAScudMissle() {
		
		PatriotBattery batteryMock = mock(PatriotBattery.class);

		Executor executor = new Executor() {
			
			@Override
			public void execute(Runnable command) {
				command.run();
			}
		};
		BetterRadar radar = new BetterRadar(batteryMock, executor);
		radar.notice(new Scud());
		verify(batteryMock, Mockito.times(10)).launchPatriot();
	
	}
}
