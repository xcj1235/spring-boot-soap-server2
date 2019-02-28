package com.howtodoinjava.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ThreadService {

	@Resource
	private ExecutorService executorService;

	public void test() {
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "スレッドテスト開始");
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				System.out.println(Thread.currentThread().getName() + "スレッドテスト終了");
			}
		});
	}
}
