/**
 * Copyright 2014 Netflix, Inc.
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
package rx.swing.sources;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.*;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.observables.SwingObservable;
import rx.subscriptions.SwingSubscriptions;

public enum MouseEventSource {
    ; // no instances

    /**
     * @see rx.observables.SwingObservable#fromMouseEvents
     */
    public static Observable<MouseEvent> fromMouseEventsOf(final Component component) {
        return Observable.create(new OnSubscribe<MouseEvent>() {
            @Override
            public void call(final Subscriber<? super MouseEvent> subscriber) {
                SwingObservable.assertEventDispatchThread();
                final MouseListener listener = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        subscriber.onNext(event);
                    }

                    @Override
                    public void mousePressed(MouseEvent event) {
                        subscriber.onNext(event);
                    }

                    @Override
                    public void mouseReleased(MouseEvent event) {
                        subscriber.onNext(event);
                    }

                    @Override
                    public void mouseEntered(MouseEvent event) {
                        subscriber.onNext(event);
                    }

                    @Override
                    public void mouseExited(MouseEvent event) {
                        subscriber.onNext(event);
                    }
                };
                component.addMouseListener(listener);

                subscriber.add(SwingSubscriptions.unsubscribeInEventDispatchThread(new Action0() {
                    @Override
                    public void call() {
                        component.removeMouseListener(listener);
                    }
                }));
            }
        });
    }

    /**
     * @see rx.observables.SwingObservable#fromMouseClickedEvents
     */
    public static Observable<MouseEvent> fromMouseClickedEventsOf(final Component component) {
        return Observable.create(new OnSubscribe<MouseEvent>() {
            @Override
            public void call(final Subscriber<? super MouseEvent> subscriber) {
                SwingObservable.assertEventDispatchThread();
                final MouseListener listener = new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        subscriber.onNext(event);
                    }
                };
                component.addMouseListener(listener);

                subscriber.add(SwingSubscriptions.unsubscribeInEventDispatchThread(new Action0() {
                    @Override
                    public void call() {
                        component.removeMouseListener(listener);
                    }
                }));
            }
        });
    }

    /**
     * @see rx.observables.SwingObservable#fromMousePressedEvents
     */
    public static Observable<MouseEvent> fromMousePressedEventsOf(final Component component) {
        return Observable.create(new OnSubscribe<MouseEvent>() {
            @Override
            public void call(final Subscriber<? super MouseEvent> subscriber) {
                SwingObservable.assertEventDispatchThread();
                final MouseListener listener = new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent event) {
                        subscriber.onNext(event);
                    }
                };
                component.addMouseListener(listener);

                subscriber.add(SwingSubscriptions.unsubscribeInEventDispatchThread(new Action0() {
                    @Override
                    public void call() {
                        component.removeMouseListener(listener);
                    }
                }));
            }
        });
    }

    /**
     * @see rx.observables.SwingObservable#fromMouseReleasedEvents
     */
    public static Observable<MouseEvent> fromMouseReleasedEventsOf(final Component component) {
        return Observable.create(new OnSubscribe<MouseEvent>() {
            @Override
            public void call(final Subscriber<? super MouseEvent> subscriber) {
                SwingObservable.assertEventDispatchThread();
                final MouseListener listener = new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent event) {
                        subscriber.onNext(event);
                    }
                };
                component.addMouseListener(listener);

                subscriber.add(SwingSubscriptions.unsubscribeInEventDispatchThread(new Action0() {
                    @Override
                    public void call() {
                        component.removeMouseListener(listener);
                    }
                }));
            }
        });
    }

    /**
     * @see rx.observables.SwingObservable#fromMouseEnteredEvents
     */
    public static Observable<MouseEvent> fromMouseEnteredEventsOf(final Component component) {
        return Observable.create(new OnSubscribe<MouseEvent>() {
            @Override
            public void call(final Subscriber<? super MouseEvent> subscriber) {
                SwingObservable.assertEventDispatchThread();
                final MouseListener listener = new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent event) {
                        subscriber.onNext(event);
                    }
                };
                component.addMouseListener(listener);

                subscriber.add(SwingSubscriptions.unsubscribeInEventDispatchThread(new Action0() {
                    @Override
                    public void call() {
                        component.removeMouseListener(listener);
                    }
                }));
            }
        });
    }

    /**
     * @see rx.observables.SwingObservable#fromMouseExitedEvents
     */
    public static Observable<MouseEvent> fromMouseExitedEventsOf(final Component component) {
        return Observable.create(new OnSubscribe<MouseEvent>() {
            @Override
            public void call(final Subscriber<? super MouseEvent> subscriber) {
                SwingObservable.assertEventDispatchThread();
                final MouseListener listener = new MouseAdapter() {
                    @Override
                    public void mouseExited(MouseEvent event) {
                        subscriber.onNext(event);
                    }
                };
                component.addMouseListener(listener);

                subscriber.add(SwingSubscriptions.unsubscribeInEventDispatchThread(new Action0() {
                    @Override
                    public void call() {
                        component.removeMouseListener(listener);
                    }
                }));
            }
        });
    }

    /**
     * @see rx.observables.SwingObservable#fromMouseMotionEvents
     */
    public static Observable<MouseEvent> fromMouseMotionEventsOf(final Component component) {
        return Observable.create(new OnSubscribe<MouseEvent>() {
            @Override
            public void call(final Subscriber<? super MouseEvent> subscriber) {
                SwingObservable.assertEventDispatchThread();
                final MouseMotionListener listener = new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent event) {
                        subscriber.onNext(event);
                    }

                    @Override
                    public void mouseMoved(MouseEvent event) {
                        subscriber.onNext(event);
                    }
                };
                component.addMouseMotionListener(listener);

                subscriber.add(SwingSubscriptions.unsubscribeInEventDispatchThread(new Action0() {
                    @Override
                    public void call() {
                        component.removeMouseMotionListener(listener);
                    }
                }));
            }
        });
    }

    public static Observable<MouseWheelEvent> fromMouseWheelEvents(final Component component){
        return Observable.create(new OnSubscribe<MouseWheelEvent>() {
            @Override
            public void call(final Subscriber<? super MouseWheelEvent> subscriber) {
                final MouseWheelListener listener = new MouseWheelListener() {
                    @Override
                    public void mouseWheelMoved(MouseWheelEvent event) {
                        subscriber.onNext(event);
                    }
                };
                component.addMouseWheelListener(listener);

                subscriber.add(SwingSubscriptions.unsubscribeInEventDispatchThread(new Action0() {
                    @Override
                    public void call() {
                        component.removeMouseWheelListener(listener);
                    }
                }));
            }
        });
    }

    /**
     * @see rx.observables.SwingObservable#fromRelativeMouseMotion
     */
    public static Observable<Point> fromRelativeMouseMotion(final Component component) {
        final Observable<MouseEvent> events = fromMouseMotionEventsOf(component);
        return Observable.zip(events, events.skip(1), new Func2<MouseEvent, MouseEvent, Point>() {
            @Override
            public Point call(MouseEvent ev1, MouseEvent ev2) {
                return new Point(ev2.getX() - ev1.getX(), ev2.getY() - ev1.getY());
            }
        });
    }

}
