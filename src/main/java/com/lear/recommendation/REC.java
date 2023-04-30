package com.lear.recommendation;

import com.lear.entity.Book;

import java.util.ArrayList;

/**
 * @author wishrem
 * @version 1.0.0
 */
public class REC {
	private final String datasetPath;

	/**
	 * 推荐系统，集成了记入rating操作，定时再训练和推荐预测等功能
	 * @param retrainMinutes 重新聚类时间，建议30min以上
	 * @param datasetPath 数据集的绝对路径
	 * */
	public REC(final int retrainMinutes, final String datasetPath){
		this.datasetPath = datasetPath;
		Ticker ticker = new Ticker(retrainMinutes);
		ticker.start();
	}

	/**
	 * 记入用户的评分行为，用于重新聚类训练
	 * @apiNote 注意：存在异步写文件操作
	 * @param userId 进行评分的用户id
	 * @param book 被评分的书籍
	 * @param score 评分数
	 *
	 * @return 返回是否成功，成功为true，失败为false，失败需要再次请求，以保证预测精准
	 * */
	public boolean recordeRatingAction(final String userId, final Book book, final int score) {
		return false;
	}

	/**
	 * 推荐预测
	 * @param userId 被推荐的用户的id
	 * @param amount 推荐书的数量
	 * @return 返回推荐列表，以RECResult.recRating从大到小排列，共amount个
	 */
	public ArrayList<RECResult> rec(final String userId, final int amount) {
		return null;
	}
}
