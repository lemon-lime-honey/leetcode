/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    var result = init;

    const increment = function() {
        result++;
        return result;
    }

    const decrement = function() {
        result--;
        return result;
    }

    const reset = function() {
        result = init;
        return init;
    }

    return { increment, decrement, reset }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */