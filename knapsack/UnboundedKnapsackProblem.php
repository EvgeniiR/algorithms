<?php

declare(strict_types=1);

class UnboundedKnapsackProblem
{
    /**
     * @see https://en.wikipedia.org/wiki/Knapsack_problem
     * @param int[] $itemSizes
     * @psalm-param list<int> $itemSizes
     *
     * @return int maximum amount of space than can be occupied by provided set of items
     */
    public function solve(int $maxBackpackSize, array $itemSizes): int {
        $matrix = [];
        foreach ($itemSizes as $row => $itemSize) {
            $matrix[$row] = [];
            for($bpSize = 0; $bpSize <= $maxBackpackSize; $bpSize++) {
                $topValue = $row === 0 ? 0 : $matrix[$row - 1][$bpSize];
                $leftValue = $bpSize === 0 ? 0 : $matrix[$row][$bpSize - 1];

                if($itemSize > $bpSize) {
                    $matrix[$row][$bpSize] = max($topValue, $leftValue);
                }

                if($itemSize === $bpSize) {
                    $matrix[$row][$bpSize] = max($topValue, $leftValue, $itemSize);
                }

                if($itemSize < $bpSize) {
                    $remainingSpaceSizeUsage = $matrix[$row][$bpSize - $itemSize];

                    $matrix[$row][$bpSize] = max(
                        $topValue,
                        $leftValue,
                        $itemSize + $remainingSpaceSizeUsage
                    );
                }
            }
        }
        $lastRow = end($matrix);
        return end($lastRow);
    }
}