package com.colofabrix.scala.gfx.Controls

import com.colofabrix.scala.geometry.shapes.Box
import com.colofabrix.scala.math.Vector2D
import org.lwjgl.input.Mouse

/**
 * Created by Freddie on 19/05/2015.
 *
 * This class contains all the buttons for controlling the game
 * The update() method should be called once per step to check for any
 * clicks. If any clicks are found within a button, that button's
 * action will be called
 */
class InputManager {
  /**
   * The buttons of the InputManager
   */
  val buttons = Seq(
    new ButtonControl( Box(Vector2D.new_xy(100, 100), Vector2D.new_xy(130, 130) ), null, (mb: Int) => { println("hi") } )
  )

  /**
   * Check for mouse clicks in any button an run the appropriate action if found
   */
  def update() {
    val mouse = Vector2D.new_xy(Mouse.getX, Mouse.getY)

    buttons.foreach { btn =>
      btn.clickTimerInc()
      if (Mouse.isButtonDown(0))
        btn.runClick( mouse, 0 )
    }
  }

}
