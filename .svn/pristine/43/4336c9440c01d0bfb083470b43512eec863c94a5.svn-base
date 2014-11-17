package RK4;

import RK4.CollisionTest.Derivative;

public class CollisionTest
{
	public void integrate(State state, float t, float dt)
    {
         Derivative a = evaluate(state, t, 0.0f, new Derivative());
         Derivative b = evaluate(state, t, dt*0.5f, a);
         Derivative c = evaluate(state, t, dt*0.5f, b);
         Derivative d = evaluate(state, t, dt, c);

         float dxdt = 1.0f/6.0f * (a.dx + 2.0f*(b.dx + c.dx) + d.dx);
         float dvdt = 1.0f/6.0f * (a.dv + 2.0f*(b.dv + c.dv) + d.dv);

         state.x = state.x + dxdt * dt;
         state.v = state.v + dvdt * dt;
    }
	
	private Derivative evaluate(State initial, float t, float dt, Derivative d)
    {
         State state = new State();
         state.x = initial.x + d.dx*dt;
         state.v = initial.v + d.dv*dt;

         Derivative output = new Derivative();
         output.dx = state.v;
         output.dv = acceleration(state, t+dt);
         return output;
    }
	
	private float acceleration(State state, float t)
    {
         float k = 10;
         float b = 1;
         return -k * state.x - b*state.v;
    }
	
	class State
	{
		float x;          // position
        float v;          // velocity
	}
	
	class Derivative
	{
		float dx;          // derivative of position: velocity
        float dv;          // derivative of velocity: acceleration
	}
}
