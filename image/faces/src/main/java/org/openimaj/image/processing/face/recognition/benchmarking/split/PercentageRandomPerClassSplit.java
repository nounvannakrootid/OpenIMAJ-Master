/**
 * Copyright (c) 2011, The University of Southampton and the individual contributors.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *   * 	Redistributions of source code must retain the above copyright notice,
 * 	this list of conditions and the following disclaimer.
 *
 *   *	Redistributions in binary form must reproduce the above copyright notice,
 * 	this list of conditions and the following disclaimer in the documentation
 * 	and/or other materials provided with the distribution.
 *
 *   *	Neither the name of the University of Southampton nor the names of its
 * 	contributors may be used to endorse or promote products derived from this
 * 	software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.openimaj.image.processing.face.recognition.benchmarking.split;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openimaj.image.processing.face.detection.DetectedFace;
import org.openimaj.image.processing.face.recognition.benchmarking.dataset.FaceDataset;
import org.openimaj.image.processing.face.recognition.benchmarking.dataset.FaceInstance;

public class PercentageRandomPerClassSplit<K, T extends DetectedFace> extends FaceDatasetSplitter<K, T> {
	private float trainingPercentage;

	public PercentageRandomPerClassSplit(float trainingPercentage) {
		this.trainingPercentage = trainingPercentage;
	}

	@Override
	public void split(FaceDataset<K, T> dataset) {
		 training = new FaceDataset<K, T>();
		 testing = new FaceDataset<K, T>();
		
		for (K key : dataset.getGroups()) {
			List<FaceInstance<T>> instances = new ArrayList<FaceInstance<T>>(dataset.getItems(key).getList());
			Collections.shuffle(instances);
			
			int trainingSamples = (int)Math.round(trainingPercentage*instances.size());
			
			training.addItems(key, instances.subList(0, trainingSamples));
			testing.addItems(key, instances.subList(trainingSamples, instances.size()));
		}
	}
}