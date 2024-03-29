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
package org.openimaj.experiment.dataset;

/**
 * An {@link Identifiable} is an object that has an associated identifier.
 * Two instances of {@link Identifiable} with the same identifier
 * should be considered equal. 
 * 
 * {@link Identifiable}s are used in {@link Dataset} as a way
 * of relating a Java object instance back to the original
 * data entity from which it was derived. Within a {@link Dataset}
 * each unique instance should have a unique identifier. 
 * {@link Dataset}s can of course contain multiple instances of the
 * same {@link Identifiable}.
 * 
 * @author Jonathon Hare (jsh2@ecs.soton.ac.uk)
 */
public interface Identifiable {
	/**
	 * @return the identifier of this object
	 */
	public String getID();
	
	/**
	 * Tests if this {@link Identifiable} is equal to a given  
	 * {@link Object} instance. Equality is defined by equality 
	 * of the identifier.
	 * 
	 * @param o the object to compare to
	 * @return true if equal; false otherwise
	 */
	@Override
	public boolean equals(Object o);
}
