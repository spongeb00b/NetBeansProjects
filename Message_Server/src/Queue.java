/* Copyright (c) 1996, 1997 Prominence Dot Com, Inc.        *
 * See the file legal.txt in the txt directory for details. */

//package prominence.util;

import java.util.Vector;

/**
 * A FIFO (first in, first out) data-structure; the opposite of a <tt>Stack</tt>.
 * Objects are added to the front of the <tt>Queue</tt> and removed from the back.
 * <p>This implementation blocks the caller who attempts to remove an object from
 * an empty queue until the queue is non-empty again.
 *
 * @version 1.0 1 Nov 1996
 * @author Merlin Hughes
 */
public class Queue {
  /**
   * A <tt>Vector</tt> of the queue elements.
   */
  protected Vector queue;

  /**
   * Creates a new, empty <tt>Queue</tt>.
   */
  public Queue () {
    queue = new Vector ();
  }

  /**
   * Attempts to remove an object from the queue; blocks if there are no objects
   * in the queue. This call will therefore always return an object.
   * @returns The least-recently-added object from the queue
   */
  public Object remove () {
    synchronized (queue) {
      while (queue.isEmpty ()) {
        try {
          queue.wait ();
        } catch (InterruptedException ex) {}
      }
      Object item = queue.firstElement ();
      queue.removeElement (item);
      return item;
    }
  }

  /**
   * Adds an item to the front of the queue, wakes a caller who is waiting for
   * the queue to become non-empty.
   * @param item The object to be added
   */
  public void add (Object item) {
    synchronized (queue) {
      queue.addElement (item);
      queue.notify ();
    }
  }

  /**
   * Returns whether the queue is empty.
   * @returns Whether the queue is empty
   */
  public boolean isEmpty () {
    return queue.isEmpty ();
  }
}

